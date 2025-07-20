package com.ecom.service;

import com.ecom.dto.product.ProductRequest;
import com.ecom.dto.product.ProductResponse;
import com.ecom.exception.ProductNotFoundException;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductResponse getProductByID(Integer id) {
        Product product = productRepository.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "The Product with id: " + id + " was not found."));
        return new ProductResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.getAllProducts().orElseThrow(
                () -> new ProductNotFoundException("Products could not be found.")
        );
        return products.stream().map(ProductResponse::new).toList();
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest);
        productRepository.save(product);
        return new ProductResponse(product);
    }

    public Integer deleteProductByID(int id) {
        Product product = productRepository.getProductById(id).orElseThrow(
                () -> new ProductNotFoundException("The Product with id: " + id + " was not found.")
        );
        productRepository.delete(product);
        return product.getId();
    }

    public ProductResponse updateProductByID(int id, ProductRequest productRequest) {
        Product product = productRepository.getProductById(id).orElseThrow(
                () -> new ProductNotFoundException("The Product with id: " + id + " was not found.")
        );
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setCategories(productRequest.getCategories());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        productRepository.save(product);
        return new ProductResponse(product);
    }
}
