package com.ecom.dto.product;

import com.ecom.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private Set<Category> categories;
    private String description;
    private double price;
    private int quantity;
}
