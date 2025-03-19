package ite.istad.category.controller;

import ite.istad.category.dto.CategoryCreateRequest;
import ite.istad.category.model.Category;
import ite.istad.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("showForm", false);
        return "categories";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("categoryCreateRequest", new CategoryCreateRequest("", false));
        model.addAttribute("showForm", true);
        model.addAttribute("editId", null);
        return "categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        CategoryCreateRequest request = new CategoryCreateRequest(
                category.getName(),
                category.getIsDeleted()
        );

        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("categoryCreateRequest", request);
        model.addAttribute("showForm", true);
        model.addAttribute("editId", id);
        return "categories";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute CategoryCreateRequest categoryCreateRequest) {
        categoryService.addCategory(categoryCreateRequest);
        return "redirect:/categories";
    }

    @PostMapping("/update")
    public String updateCategory(@RequestParam("id") Long id,
                                 @ModelAttribute CategoryCreateRequest categoryCreateRequest) {
        categoryService.updateCategory(categoryCreateRequest, id);
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}