package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.*;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.service.BookService;
import com.kodilla.kodillalibrary.service.UserService;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoanMapperTest {
    private final Loan loan;
    private final LoanDto loanDto;
    private final BookTitle bookTitle;
    private final Book book;
    private final User user;
    private final LoanMapper mapper;
    private final BookService bookService;
    private final UserService userService;
    private final LocalDate date;

    public LoanMapperTest() {
        this.bookTitle = new BookTitle(1, "test title", "test author", LocalDate.now().minusYears(3));
        this.book = new Book(1, bookTitle, Book.LOANED);
        this.user = new User(1, "test name", "tet surname", LocalDate.now().minusMonths(6));
        this.bookService = mock(BookService.class);
        this.userService = mock(UserService.class);
        this.date = LocalDate.now();
        this.mapper = new LoanMapper(bookService, userService);
        this.loan = new Loan(1, book, user, date, null);
        this.loanDto = new LoanDto(1, 1, 1, date, null);
    }

    @Test
    public void mapToLoan() {
        //Given
        when(bookService.findBookById(1)).thenReturn(book);
        when(userService.findUserById(1)).thenReturn(user);

        //When
        Loan testLoan = mapper.mapToLoan(loanDto);

        //Then
        assertEquals(loan, testLoan);
    }

    @Test
    public void mapToLoanDto() {
        //When
        LoanDto testLoanDto = mapper.mapToLoanDto(loan);

        //Then
        assertEquals(loanDto, testLoanDto);
    }
}