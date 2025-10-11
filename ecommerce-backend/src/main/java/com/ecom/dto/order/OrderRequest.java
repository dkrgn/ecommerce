package com.ecom.dto.order;

import com.ecom.dto.orderitem.OrderItemRequest;
import com.ecom.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {

    private Integer id;
    private LocalDate orderDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private String shippingAddress;
    private Set<OrderItemRequest> orderItems;
}
