package com.ecom.repository;

import com.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products WHERE id = ?", nativeQuery = true)
    Optional<Product> getProductById(Integer id);

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    Optional<List<Product>> getAllProducts();
}
