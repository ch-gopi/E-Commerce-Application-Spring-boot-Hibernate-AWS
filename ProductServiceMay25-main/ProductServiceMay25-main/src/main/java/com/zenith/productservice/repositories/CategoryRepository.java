package com.zenith.productservice.repositories;

import com.zenith.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String name);

    @Override
    void deleteById(Long categoryId);
}
