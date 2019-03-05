package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exception.LoanNotFoundException;
import com.kodilla.kodillalibrary.repository.LoanRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoanServiceTestSuit {
    private final LoanRepository loanRepository;
    private final LoanService loanService;
    private final BookService bookService;

    public LoanServiceTestSuit() {
        this.loanRepository = mock(LoanRepository.class);
        this.bookService = mock(BookService.class);
        this.loanService = new LoanService(loanRepository, bookService);
    }

    @Test
    public void addLoanTest() {
        //Given
        Book book = new Book(1, null, Book.AVAILABLE);
        User user = new User(1, "test name", "test surname", LocalDate.now());
        Loan loan = new Loan(1, book, user, LocalDate.now(), null);
        when(loanRepository.save(any())).thenReturn(loan);

        //When
        Loan testLoan = loanService.addLoan(book, user);

        //Then
        assertEquals(loan, testLoan);
    }

    @Test
    public void returnLoanedBookTest() {
        //Given
        Book book = new Book(1, null, Book.AVAILABLE);
        User user = new User(1, "test name", "test surname", LocalDate.now());
        Loan loan = new Loan(1, book, user, LocalDate.now(), LocalDate.now().plusDays(1));
        when(loanRepository.save(any())).thenReturn(loan);
        when(loanRepository.findById(any())).thenReturn(Optional.of(loan));

        //When
        Loan testLoan = loanService.returnLoanedBook(1);

        //Then
        assertEquals(loan, testLoan);
    }

    @Test
    public void findLoanByIdTestWithValidId() {
        //Given
        Book book = new Book(1, null, Book.AVAILABLE);
        User user = new User(1, "test name", "test surname", LocalDate.now());
        Loan loan = new Loan(1, book, user, LocalDate.now(), LocalDate.now().plusDays(1));
        when(loanRepository.findById(any())).thenReturn(Optional.of(loan));

        //When
        Loan testLoan = loanService.findLoanById(1);

        //Then
        assertEquals(loan, testLoan);
    }

    @Test(expected = LoanNotFoundException.class)
    public void findLoanByIdTestWithoutValidId() {
        //Given
        Book book = new Book(1, null, Book.AVAILABLE);
        User user = new User(1, "test name", "test surname", LocalDate.now());
        Loan loan = new Loan(1, book, user, LocalDate.now(), LocalDate.now().plusDays(1));
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        //When
        loanService.findLoanById(2);
    }
}
