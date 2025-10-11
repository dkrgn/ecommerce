package com.ecom.dto.orderitem;


import com.ecom.dto.order.OrderRequest;
import com.ecom.dto.order.OrderResponse;
import com.ecom.dto.product.ProductRequest;
import com.ecom.dto.product.ProductResponse;
import com.ecom.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemRequest {

    private int quantity;
    private BigDecimal price;

    public OrderItemRequest(OrderItem orderItem) {
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }
}
