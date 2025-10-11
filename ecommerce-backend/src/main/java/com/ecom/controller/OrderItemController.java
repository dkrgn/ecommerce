package com.ecom.controller;

import com.ecom.dto.orderitem.OrderItemRequest;
import com.ecom.dto.orderitem.OrderItemResponse;
import com.ecom.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
@AllArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponse> getOrderItemById(@PathVariable int id) {
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponse>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }

    @PostMapping
    public ResponseEntity<OrderItemResponse> createOrderItem(@RequestBody OrderItemRequest orderRequest) {
        return ResponseEntity.ok(orderItemService.saveOrderItem(orderRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderItemResponse> deleteOrderItem(@PathVariable int id) {
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }
}
