package com.zenith.productservicemay25.repositories;

import com.zenith.productservicemay25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String name);

    @Override
    void deleteById(Long categoryId);
}
