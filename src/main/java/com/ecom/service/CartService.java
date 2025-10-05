package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecom.dto.cart.CartItemResponse;
import com.ecom.dto.cart.CartRequest;
import com.ecom.dto.cart.CartResponse;
import com.ecom.exception.CartItemNotFoundException;
import com.ecom.exception.CartNotFoundException;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.repository.CartItemRepository;
import com.ecom.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService {
    
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartResponse getCartById(int id) {
        Cart cart = cartRepository.getCartById(id).orElseThrow(
            () -> new CartNotFoundException("Cart not found with id: " + id + " not found."));
        return new CartResponse(cart);
    }

    public List<CartResponse> getAllCarts() {
        List<Cart> carts = cartRepository.getAllCarts().orElseThrow(() -> new CartNotFoundException("Carts not found"));
        return carts.stream().map(CartResponse::new).collect(Collectors.toList());
    }

    public CartResponse createCart(CartRequest cartRequest) {
        Cart cart = cartRepository.getCartById(cartRequest.getId()).orElseThrow(
            () -> new CartNotFoundException("Cart not found with id: " + cartRequest.getId() + " not found.")
        );
        cartRepository.save(cart);
        return new CartResponse(cart);
    }

    public CartResponse deleteCartById(int id) {
        Cart cart = cartRepository.getCartById(id).orElseThrow(
            () -> new CartNotFoundException("Cart not found with id: " + id + " not found.")
        );
        cartRepository.delete(cart);
        return new CartResponse(cart);
    }

    public CartItemResponse deleteProductFromCart(int id) {
        CartItem cartItem = cartItemRepository.getCartItemById(id).orElseThrow(
            () -> new CartItemNotFoundException("CartItem with id: " + id + " not found.")
        );
        cartItemRepository.delete(cartItem);
        return new CartItemResponse(cartItem);
    }
}
