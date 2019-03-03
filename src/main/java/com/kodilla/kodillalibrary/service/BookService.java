package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.exception.BookNotFoundExceptin;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.BookTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookTitleRepository bookTitleRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookTitleRepository bookTitleRepository) {
        this.bookRepository = bookRepository;
        this.bookTitleRepository = bookTitleRepository;
    }

    BookTitle addBookTitle(BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    Book addBook(Book book) {
        return bookRepository.save(book);
    }

    Book updateBookStatus(Book book, long id) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(BookNotFoundExceptin::new);
        bookToUpdate.setStatus(book.getStatus());
        return bookRepository.save(bookToUpdate);
    }

    int howManyBooksAvailable(BookTitle bookTitle) {
        return bookRepository.findAllByBookTitleAndStatus(bookTitle, Book.AVAILABLE).size();
    }
}
