package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import com.kodilla.kodillalibrary.service.BookService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    private final BookService service;

    public BookMapper(BookService service) {
        this.service = service;
    }

    public Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getId(),
                service.findBookTitleById(bookDto.getBookTitleDto().getId()),
                bookDto.getStatus());
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        return new BookTitle(bookTitleDto.getId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getPublicationDate());
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(),
                mapToBookTitleDto(book.getBookTitle()),
                book.getStatus());
    }

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        return new BookTitleDto(bookTitle.getId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublicationDate());
    }

    public List<BookDto> mapToBookDtoList(List<Book> books) {
        return books.stream().map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
