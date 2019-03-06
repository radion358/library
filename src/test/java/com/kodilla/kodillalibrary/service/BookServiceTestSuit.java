package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.exception.BookNotFoundExceptin;
import com.kodilla.kodillalibrary.exception.BookTitleNotFoundException;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.BookTitleRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTestSuit {
    private BookRepository bookRepository;
    private BookTitleRepository bookTitleRepository;
    private BookService service;

    public BookServiceTestSuit() {
        this.bookRepository = mock(BookRepository.class);
        this.bookTitleRepository = mock(BookTitleRepository.class);
        this.service = new BookService(bookRepository, bookTitleRepository);
    }

    @Test
    public void saveBookTitleTest() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        when(bookTitleRepository.save(bookTitle)).thenReturn(bookTitle);

        //When
        BookTitle testBookTitle = service.saveBookTitle(bookTitle);

        //Then
        assertEquals(bookTitle, testBookTitle);
    }

    @Test
    public void saveBookTest() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        Book book = new Book(1, bookTitle, Book.DAMAGED);
        when(bookRepository.save(book)).thenReturn(book);

        //When
        Book testBook = service.saveBook(book);

        //Then
        assertEquals(book, testBook);
    }

    @Test
    public void updateBookStatusTest() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        Book book = new Book(1, bookTitle, Book.DAMAGED);
        Book bookWithUpdatedStatus = new Book(1, bookTitle, Book.AVAILABLE);
        when(bookRepository.save(any())).thenReturn(bookWithUpdatedStatus);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        //When
        Book testBook = service.updateBookStatus(Book.AVAILABLE, 1);

        //Then
        assertEquals(bookWithUpdatedStatus, testBook);
    }

    @Test
    public void findBookByIdWithValidId() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        Book book = new Book(1, bookTitle, Book.DAMAGED);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        //When
        Book testBook = service.findBookById(1);

        //Then
        assertEquals(book, testBook);
    }

    @Test(expected = BookNotFoundExceptin.class)
    public void findBookByIdWithoutValidId() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        Book book = new Book(1, bookTitle, Book.DAMAGED);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        //When
        service.findBookById(2);
    }

    @Test
    public void findBookTitleByIdWithValidId() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        when(bookTitleRepository.findById(1L)).thenReturn(Optional.of(bookTitle));

        //When
        BookTitle testBookTitle = service.findBookTitleById(1);

        //Then
        assertEquals(bookTitle, testBookTitle);
    }

    @Test(expected = BookTitleNotFoundException.class)
    public void findBookTitleByIdWithoutValidId() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        when(bookTitleRepository.findById(1L)).thenReturn(Optional.of(bookTitle));

        //When
        service.findBookTitleById(2);
    }

    @Test
    public void findAvailableBooksByBookTitle() {
        //Given
        BookTitle bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now());
        Book firstBook = new Book(1, bookTitle, Book.AVAILABLE);
        Book secondBook = new Book(2, bookTitle, Book.AVAILABLE);
        List<Book> books = new ArrayList<>();
        books.add(firstBook);
        books.add(secondBook);
        when(bookRepository.findAllByBookTitleAndStatus(bookTitle, Book.AVAILABLE)).thenReturn(books);

        //When
        int returnedListSize = service.findAvailableBooksByBookTitle(bookTitle).size();

        //Then
        assertEquals(2, returnedListSize);
    }
}
