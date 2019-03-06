package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.BookTitle;
import com.kodilla.kodillalibrary.domain.BookTitleDto;
import com.kodilla.kodillalibrary.service.BookService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMapperTest {
    //Given
    private final LocalDate date;
    private final BookTitle bookTitle;
    private final Book book;
    private final BookTitleDto bookTitleDto;
    private final BookDto bookDto;
    private final BookService service;
    private final BookMapper mapper;

    public BookMapperTest() {
        this.date = LocalDate.now();
        this.bookTitle = new BookTitle(1, "test title", "test author", date);
        this.book = new Book(1, bookTitle, Book.AVAILABLE);
        this.bookTitleDto = new BookTitleDto(1, "test title", "test author", date);
        this.bookDto = new BookDto(1, bookTitleDto, Book.AVAILABLE);
        this.service = mock(BookService.class);
        this.mapper = new BookMapper(service);
    }

    @Test
    public void mapToBook() {
        //Given
        when(service.findBookTitleById(1)).thenReturn(bookTitle);

        //When
        Book testBook = mapper.mapToBook(bookDto);

        //Then
        assertEquals(book, testBook);
    }

    @Test
    public void mapToBookTitle() {
        //When
        BookTitle testBookTitle = mapper.mapToBookTitle(bookTitleDto);

        //Then
        assertEquals(bookTitle, testBookTitle);
    }

    @Test
    public void mapToBookDto() {
        //When
        BookDto testBookDto = mapper.mapToBookDto(book);

        //Then
        assertEquals(bookDto, testBookDto);
    }

    @Test
    public void mapToBookTitleDto() {
        //When
        BookTitleDto testBookTitleDto = mapper.mapToBookTitleDto(bookTitle);

        //Then
        assertEquals(bookTitleDto, testBookTitleDto);
    }

    @Test
    public void mapToBookDtoList() {
        //Given
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book);
        books.add(book);

        //When
        List<BookDto> bookDtos = mapper.mapToBookDtoList(books);

        //Then
        assertEquals(3, bookDtos.size());
    }
}