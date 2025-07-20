package com.ecom.repository;

import com.ecom.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders WHERE id = ?", nativeQuery = true)
    Optional<Order> getOrderById(Integer id);

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    Optional<List<Order>> getAllOrders();

    @Query(value = "SELECT * FROM orders WHERE user_id = ?", nativeQuery = true)
    Optional<List<Order>> getOrdersByUserId(int id);
}
