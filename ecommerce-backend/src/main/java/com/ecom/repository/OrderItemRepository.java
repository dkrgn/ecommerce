package com.ecom.repository;

import com.ecom.model.Category;
import com.ecom.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query(value = "SELECT * FROM order_item WHERE id = ?", nativeQuery = true)
    Optional<OrderItem> getOrderItemById(Integer id);

    @Query(value = "SELECT * FROM order_item", nativeQuery = true)
    Optional<List<OrderItem>> getAllOrderItems();
}
