package com.ecom.dto.orderitem;

import com.ecom.dto.order.OrderResponse;
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
public class OrderItemResponse {

    private Integer id;
    private int quantity;
    private BigDecimal price;
    private ProductResponse product;
    private int orderId;

    public OrderItemResponse(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.product = new ProductResponse(orderItem.getProduct());
        this.orderId = orderItem.getOrder().getId();
    }
}
