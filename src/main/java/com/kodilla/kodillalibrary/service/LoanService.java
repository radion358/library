package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exception.LoanNotFoundException;
import com.kodilla.kodillalibrary.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public Loan addLoan(Book book, User user) {
        book.setStatus(Book.LOANED);
        return loanRepository.save(new Loan(book, user, new Date()));
    }

    public Loan returnLoanedBook(long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
        Book book = loan.getBook();
        book.setStatus(Book.AVAILABLE);
        bookService.updateBookStatus(book, book.getId());
        loan.setReturnDate(new Date());
        return loanRepository.save(loan);
    }
}
