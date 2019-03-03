package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {

    }

    @PostMapping
    public void addBookTitle(@RequestBody BookTitleDto bookTitleDto) {

    }

    @PatchMapping
    @RequestMapping("/{id}")
    public void changeStatus(@RequestBody BookDto bookDto, @RequestParam Long id) {

    }

    @GetMapping
    public void getAvailableBooks(@RequestParam String bookName) {

    }
}
