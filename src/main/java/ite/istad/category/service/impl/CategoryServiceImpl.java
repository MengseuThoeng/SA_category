package ite.istad.category.service.impl;

import ite.istad.category.dto.CategoryCreateRequest;
import ite.istad.category.model.primary.Category;
import ite.istad.category.repository.primaryRepo.CategoryRepository;
import ite.istad.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(CategoryCreateRequest category) {
        Category category1 = new  Category();
        category1.setName(category.name());
        category1.setIsDeleted(category.isDeleted());
        categoryRepository.save(category1);
    }

    @Override
    public void updateCategory(CategoryCreateRequest category, Long id) {
        Category category1 = categoryRepository.findById(id).orElseThrow();
        category1.setName(category.name());
        category1.setIsDeleted(category.isDeleted());
        categoryRepository.save(category1);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
