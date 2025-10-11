package com.ecom.service;

import com.ecom.dto.order.OrderRequest;
import com.ecom.dto.order.OrderResponse;
import com.ecom.dto.orderitem.OrderItemRequest;
import com.ecom.dto.orderitem.OrderItemResponse;
import com.ecom.exception.OrderItemNotFoundException;
import com.ecom.exception.OrderNotFoundException;
import com.ecom.model.Order;
import com.ecom.model.OrderItem;
import com.ecom.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemResponse getOrderItemById(int id) {
        OrderItem orderItem = orderItemRepository.getOrderItemById(id).orElseThrow(
                () -> new OrderItemNotFoundException("OrderItem not found")
        );
        return new OrderItemResponse(orderItem);
    }

    public List<OrderItemResponse> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.getAllOrderItems().orElseThrow(
                () -> new OrderItemNotFoundException("OrderItems not found")
        );
        return orderItems.stream().map(OrderItemResponse::new).collect(Collectors.toList());
    }

    public OrderItemResponse saveOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem order = new OrderItem(orderItemRequest);
        orderItemRepository.save(order);
        return new OrderItemResponse(order);
    }

    public int deleteOrderItemById(int id) {
        OrderItem order = orderItemRepository.getOrderItemById(id).orElseThrow(
                () -> new OrderNotFoundException("OrderItem not found")
        );
        orderItemRepository.delete(order);
        return order.getId();
    }
}
