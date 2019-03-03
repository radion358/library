package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookDto;
    }

    @PostMapping
    @RequestMapping("/title")
    public BookTitleDto addBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        return bookTitleDto;
    }

    @PatchMapping
    @RequestMapping
    public BookDto changeStatus(@RequestBody BookDto bookDto, @RequestParam Long id) {
        return bookDto;
    }

    @GetMapping
    public List<BookDto> getAvailableBooks(@RequestParam String bookName) {
        return new ArrayList<>();
    }
}
