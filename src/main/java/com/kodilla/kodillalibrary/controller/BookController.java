package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {

    }

    @PatchMapping
    @RequestMapping("/{id}")
    public void changeStatus(@RequestBody BookDto bookDto, @PathVariable Long id) {

    }

    @GetMapping
    public void getAvailableBooks(@RequestParam String bookName) {

    }
}
