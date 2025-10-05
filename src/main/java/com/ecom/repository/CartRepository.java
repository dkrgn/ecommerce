package com.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT * FROM carts WHERE id = ?", nativeQuery = true)
    Optional<Cart> getCartById(Integer id);

    @Query(value = "SELECT * FROM carts WHERE user_id = ?", nativeQuery = true)
    Optional<Cart> getCartByUserId(Integer userId);

    @Query(value = "SELECT * FROM carts", nativeQuery = true)
    Optional<List<Cart>> getAllCarts();
    
}
