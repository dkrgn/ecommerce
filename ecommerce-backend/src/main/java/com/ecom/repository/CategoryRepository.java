package com.ecom.repository;

import com.ecom.model.Category;
import com.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM categories WHERE id = ?", nativeQuery = true)
    Optional<Category> getCategoryById(Integer id);

    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    Optional<List<Category>> getAllCategories();
}
