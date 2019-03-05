package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.exception.BookNotFoundExceptin;
import com.kodilla.kodillalibrary.exception.BookTitleNotFoundException;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.BookTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookTitleRepository bookTitleRepository;

    public BookService(BookRepository bookRepository, BookTitleRepository bookTitleRepository) {
        this.bookRepository = bookRepository;
        this.bookTitleRepository = bookTitleRepository;
    }

    public BookTitle saveBookTitle(BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookStatus(String status, long id) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(BookNotFoundExceptin::new);
        bookToUpdate.setStatus(status);
        return bookRepository.save(bookToUpdate);
    }

    public List<Book> findAvailableBooksByBookTitle(BookTitle bookTitle) {
        return bookRepository.findAllByBookTitleAndStatus(bookTitle, Book.AVAILABLE);
    }

    public Book findBookById(long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundExceptin::new);
    }

    public BookTitle findBookTitleById(long id) {
        return bookTitleRepository.findById(id).orElseThrow(BookTitleNotFoundException::new);
    }
}
