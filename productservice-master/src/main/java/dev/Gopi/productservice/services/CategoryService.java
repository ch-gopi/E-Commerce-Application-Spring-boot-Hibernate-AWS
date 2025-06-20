package dev.Gopi.productservice.services;

import dev.Gopi.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
}
