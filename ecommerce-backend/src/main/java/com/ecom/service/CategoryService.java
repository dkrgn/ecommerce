package com.ecom.service;

import com.ecom.dto.category.CategoryRequest;
import com.ecom.dto.category.CategoryResponse;
import com.ecom.exception.CategoryNotFoundException;
import com.ecom.model.Category;
import com.ecom.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.getCategoryById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id: " + id + " was not found.")
        );
        return new CategoryResponse(category);
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.getAllCategories().orElseThrow(
                () -> new CategoryNotFoundException("All categories were not found.")
        );
        return categories.stream().map(CategoryResponse::new).toList();
    }

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest);
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }

    public int deleteCategoryById(Integer id) {
        Category category = categoryRepository.getCategoryById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id: " + id + " was not found.")
        );
        categoryRepository.delete(category);
        return category.getId();
    }

    public CategoryResponse updateCategory(int id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.getCategoryById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id: " + id + " was not found.")
        );
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }
}
