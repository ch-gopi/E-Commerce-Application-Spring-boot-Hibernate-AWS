package com.zenith.productservice.services;

import com.zenith.productservice.exceptions.CategoryNotFoundException;
import com.zenith.productservice.exceptions.ProductNotFoundException;
import com.zenith.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    void deleteProduct(Long productId);

    Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize);
}
