package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exception.LoanNotFoundException;
import com.kodilla.kodillalibrary.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;

    public LoanService(LoanRepository loanRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public Loan addLoan(Book book, User user) {
        bookService.updateBookStatus(Book.LOANED, book.getId());
        return loanRepository.save(new Loan(book, user, LocalDate.now()));
    }

    public Loan returnLoanedBook(long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
        Book book = loan.getBook();
        bookService.updateBookStatus(Book.AVAILABLE, book.getId());
        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    public Loan findLoanById(long id) {
        return loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
    }
}
