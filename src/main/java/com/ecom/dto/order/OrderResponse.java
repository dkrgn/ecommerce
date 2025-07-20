package com.ecom.dto.order;


import com.ecom.dto.orderitem.OrderItemResponse;
import com.ecom.model.Order;
import com.ecom.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponse {

    private Integer id;
    private LocalDate orderDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private String shippingAddress;
    private List<OrderItemResponse> orderItems;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
        this.totalPrice = order.getTotalPrice();
        this.shippingAddress = order.getShippingAddress();
        this.orderItems = order.getOrderItems().stream().map(OrderItemResponse::new).collect(Collectors.toList());
    }
}
