package com.example.assignment3_1.controller;

import com.example.assignment3_1.dto.CategoryDTO;
import com.example.assignment3_1.model.Category;
import com.example.assignment3_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-new-category")
    public Category addNewCategory(@RequestBody CategoryDTO category){
        return categoryService.addNewCategory(category);
    }

    @GetMapping("/get-all-categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/get-category/{category-id}")
    public Category getCategory(@PathVariable("category-id") Integer categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/udpate-category/{category-id}")
    public void updateCategory(@PathVariable("category-id")Integer categoryId, @RequestBody String name){
        categoryService.updateCategory(categoryId,name);
    }


}
