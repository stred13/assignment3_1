package com.example.assignment3_1.controller;

import com.example.assignment3_1.dto.BookCopyDTO;
import com.example.assignment3_1.dto.BookDTO;
import com.example.assignment3_1.dto.response.BookResponse;
import com.example.assignment3_1.model.Book;
import com.example.assignment3_1.service.BookCopyService;
import com.example.assignment3_1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookCopyService bookCopyService;

    @GetMapping("/get-all-books")
    public List<BookResponse> getBooks(){
        return bookService.viewAllBooks();
    }

    @PostMapping("/add-new-book")
    public Book addNewBook(@RequestBody BookDTO bookDTO){
        return bookService.addNewBook(bookDTO);
    }

    @PutMapping("/update-title/{book-id}")
    public void updateABook(@PathVariable("book-id")Integer bookId,@RequestBody String title){
        bookService.updateBookTitle(bookId,title);
    }

    @PutMapping("/update-copy/{copy-id}")
    public void updateCopy(@PathVariable("copy-id")Integer copyId, @RequestBody BookCopyDTO copyDTO){
        bookCopyService.udpate(copyId,copyDTO.getVersion(),copyDTO.getPublishDate());
    }
}
