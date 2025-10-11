package com.ecom.dto.cart;

import com.ecom.model.CartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemResponse {
    
    private Integer productId;
    private String productName;
    private int quantity;
    private double price; 

    public CartItemResponse(CartItem cartItem) {
        this.productId = cartItem.getProduct().getId();
        this.productName = cartItem.getProduct().getName();
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getPrice();
    }
}
