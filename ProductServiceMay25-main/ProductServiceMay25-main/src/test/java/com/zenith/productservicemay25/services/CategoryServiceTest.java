package com.zenith.productservice.services;

import com.zenith.productservice.repositories.CategoryRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;
}