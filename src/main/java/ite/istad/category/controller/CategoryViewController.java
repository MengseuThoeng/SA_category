//package ite.istad.category.controller;
//
//import ite.istad.category.service.CategoryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class CategoryViewController {
//
//    private final CategoryService categoryService;
//
//    @GetMapping("/categories")
//    public String viewCategories(Model model) {
//        model.addAttribute("categories", categoryService.getCategories());
//        return "categories";
//    }
//}