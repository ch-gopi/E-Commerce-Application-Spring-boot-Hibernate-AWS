package com.scaler.productservice.service;

import com.scaler.productservice.exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotExistsException;
    List<Product> getAllProducts();
    void addNewProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product replaceProduct(Long id, Product product);
    public List<Category> getAllCategories();
    public List<Product> getProductWithCategory(String categoryName);
}

