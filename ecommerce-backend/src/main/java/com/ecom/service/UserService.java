package com.ecom.service;

import com.ecom.dto.order.OrderResponse;
import com.ecom.dto.user.UserRequest;
import com.ecom.dto.user.UserResponse;
import com.ecom.exception.OrderNotFoundException;
import com.ecom.exception.UserNotFoundException;
import com.ecom.model.Order;
import com.ecom.model.User;
import com.ecom.repository.OrderRepository;
import com.ecom.repository.UserRepository;
import com.ecom.service.security.SecurityConfig;
import lombok.AllArgsConstructor;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;
    private final OrderRepository orderRepository;

    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    public UserResponse getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id:" + id + " was not found.")
        );
        String currentUserEmail = getCurrentUserEmail();
        if (!isAdmin() && !user.getEmail().equals(currentUserEmail)) {
            throw new AccessDeniedException("You cannot access this user's account");
        }
        return new UserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.getAllUsers().orElseThrow(
                () -> new UserNotFoundException("Users not found.")
        );
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }

    public int deleteUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id:" + id + " was not found.")
        );
        String currentUserEmail = getCurrentUserEmail();
        if (!isAdmin() && !user.getEmail().equals(currentUserEmail)) {
            throw new AccessDeniedException("You cannot access this user's account");
        }
        userRepository.deleteById(id);
        return user.getId();
    }

    public UserResponse registerUser(UserRequest request) {
        User user = new User(request);
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse updateUser(int id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id:" + id + " was not found.")
        );
        String currentUserEmail = getCurrentUserEmail();
        if (!isAdmin() && !user.getEmail().equals(currentUserEmail)) {
            throw new AccessDeniedException("You cannot access this user's account");
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        userRepository.save(user);
        return new UserResponse(user);
    }

    public List<OrderResponse> getUserOrders() {
        String email = getCurrentUserEmail();
        User user = userRepository.getUserByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User with email:" + email + " was not found.")
        );
        List<Order> orders = orderRepository.getOrdersByUserId(user.getId()).orElseThrow(
                () -> new OrderNotFoundException("Orders not found.")
        );
        return orders.stream().map(OrderResponse::new).collect(Collectors.toList());
    }
}
