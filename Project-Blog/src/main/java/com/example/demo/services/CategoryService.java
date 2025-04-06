package com.example.demo.services;

import com.example.demo.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategoryById(UUID id);

    Category createCategory(Category category);

    void deleteCategory(UUID id);
}
