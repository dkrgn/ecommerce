package com.ecom.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.cart.CartItemResponse;
import com.ecom.dto.cart.CartRequest;
import com.ecom.dto.cart.CartResponse;
import com.ecom.service.CartService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    
    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable int id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @GetMapping
    public ResponseEntity<List<CartResponse>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }
    
    @PostMapping
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartService.createCart(cartRequest));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<CartItemResponse> deleteProductFromCart(@PathVariable int id) {
        return ResponseEntity.ok(cartService.deleteProductFromCart(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CartResponse> deleteCart(@PathVariable int id) {
        return ResponseEntity.ok(cartService.deleteCartById(id));
    }
}
