package com.example.assignment3_1.repository;

import com.example.assignment3_1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    public Optional<Author> findByNameAndEmailIgnoreCase(String name, String email);
}
