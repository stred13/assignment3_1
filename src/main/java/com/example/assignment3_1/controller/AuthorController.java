package com.example.assignment3_1.controller;

import com.example.assignment3_1.dto.AuthorDTOUpdate;
import com.example.assignment3_1.dto.response.AuthorResponse;
import com.example.assignment3_1.model.Author;
import com.example.assignment3_1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/get-author/{author-id}")
    public Author getAuthor(@PathVariable("author-id") Integer authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/get-all-author")
    public List<AuthorResponse> getAllAuthor() {
        return authorService.getAllAuthors();
    }

    @PutMapping("/update-author/{author-id}")
    public void updateAuthor(@PathVariable("author-id")Integer id,@RequestBody AuthorDTOUpdate authorDTOUpdate) {
        authorService.udpateAuthor(id,authorDTOUpdate.getName(),authorDTOUpdate.getEmail());
    }
}
