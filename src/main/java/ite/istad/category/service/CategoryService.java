package ite.istad.category.service;

import ite.istad.category.dto.CategoryCreateRequest;
import ite.istad.category.model.primary.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    List<Category> getCategories();

    void addCategory(CategoryCreateRequest category);

    void updateCategory(CategoryCreateRequest category, Long id);

    void deleteCategory(Long id);

}
