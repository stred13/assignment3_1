package com.example.assignment3_1.repository;

import com.example.assignment3_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByNameIgnoreCase(String name);
}
