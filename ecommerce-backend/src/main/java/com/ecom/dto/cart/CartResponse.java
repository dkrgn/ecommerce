package com.ecom.dto.cart;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.model.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartResponse {
    
    private Integer id;
    private List<CartItemResponse> cartItems;
    private double totalPrice;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.cartItems = cart.getCartItems().stream().map(CartItemResponse::new).collect(Collectors.toList());
        this.totalPrice = cart.getTotalPrice();
    }
}
