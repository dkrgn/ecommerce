package com.ecom.dto.product;

import com.ecom.dto.category.CategoryResponse;
import com.ecom.model.Product;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Integer id;
    private String name;
    private Set<CategoryResponse> category;
    private String description;
    private double price;
    private int quantity;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.category = product.getCategories().stream().map(CategoryResponse::new).collect(Collectors.toSet());
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
