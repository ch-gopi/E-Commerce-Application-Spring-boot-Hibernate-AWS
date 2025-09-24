package com.zenith.productservicemay25.services;

import com.zenith.productservicemay25.repositories.CategoryRepository;
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