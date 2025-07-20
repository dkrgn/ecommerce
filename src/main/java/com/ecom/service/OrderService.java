package com.ecom.service;

import com.ecom.dto.order.OrderRequest;
import com.ecom.dto.order.OrderResponse;
import com.ecom.exception.OrderNotFoundException;
import com.ecom.model.Order;
import com.ecom.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse getOrderById(int id) {
        Order order = orderRepository.getOrderById(id).orElseThrow(
                () -> new OrderNotFoundException("Order not found")
        );
        return new OrderResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders().orElseThrow(
                () -> new OrderNotFoundException("Orders not found")
        );
        return orders.stream().map(OrderResponse::new).collect(Collectors.toList());
    }

    public OrderResponse saveOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest);
        orderRepository.save(order);
        return new OrderResponse(order);
    }

    public int deleteOrderById(int id) {
        Order order = orderRepository.getOrderById(id).orElseThrow(
                () -> new OrderNotFoundException("Order not found")
        );
        orderRepository.delete(order);
        return order.getId();
    }
}
