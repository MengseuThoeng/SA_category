package ite.istad.category.controller;


import ite.istad.category.dto.CategoryCreateRequest;
import ite.istad.category.model.primary.Category;
import ite.istad.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }


    @PostMapping
    public void addCategory(@RequestBody CategoryCreateRequest category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CategoryCreateRequest category, @PathVariable Long id) {
        categoryService.updateCategory(category,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
