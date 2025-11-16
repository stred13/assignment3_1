package com.example.assignment3_1.service;

import com.example.assignment3_1.dto.CategoryDTO;
import com.example.assignment3_1.model.Category;
import com.example.assignment3_1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category addNewCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void updateCategory(Integer id, String name){
        categoryRepository.findById(id).ifPresent(category -> {
            category.setName(name);
            categoryRepository.save(category);
        });
    }
}
