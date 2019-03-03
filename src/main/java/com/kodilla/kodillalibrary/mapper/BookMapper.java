package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import com.kodilla.kodillalibrary.exception.BookTitleNotFoundException;
import com.kodilla.kodillalibrary.repository.BookTitleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    private final BookTitleRepository bookTitleRepository;

    public BookMapper(BookTitleRepository bookTitleRepository) {
        this.bookTitleRepository = bookTitleRepository;
    }

    Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getId(),
                bookTitleRepository.findById(bookDto.getBookTitleDto()
                        .getId()).orElseThrow(BookTitleNotFoundException::new),
                bookDto.getStatus());
    }

    BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        return new BookTitle(bookTitleDto.getId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getPublicationDate());
    }
    
    BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(),
                mapToBookTitleDto(book.getBookTitle()),
                book.getStatus());
    }

    BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        return new BookTitleDto(bookTitle.getId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublicationDate());
    }

    List<BookDto> mapToBookDtos(List<Book> books) {
        return books.stream().map(book -> mapToBookDto(book))
                .collect(Collectors.toList());
    }
}