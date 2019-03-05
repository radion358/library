package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    private final BookMapper mapper;

    public BookController(BookService service, BookMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return mapper.mapToBookDto(service.saveBook(mapper.mapToBook(bookDto)));
    }

    @PostMapping
    @RequestMapping("/title")
    public BookTitleDto addBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        return mapper.mapToBookTitleDto(service.saveBookTitle(mapper.mapToBookTitle(bookTitleDto)));
    }

    @PatchMapping
    @RequestMapping
    public BookDto changeStatus(@RequestParam String status, @RequestParam Long id) {
        return mapper.mapToBookDto(service.updateBookStatus(status, id));
    }

    @GetMapping
    public int getAvailableBooks(@RequestBody BookTitleDto bookTitleDto) {
        return service.findAvailableBooksByBookTitle(mapper.mapToBookTitle(bookTitleDto)).size();
    }
}
