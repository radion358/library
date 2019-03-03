package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.LoanDto;
import com.kodilla.kodillalibrary.service.BookService;
import com.kodilla.kodillalibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public LoanMapper(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public Loan mapToLoan(LoanDto loanDto) {
        return new Loan(loanDto.getId(),
                bookService.findBookById(loanDto.getBookId()),
                userService.findUserById(loanDto.getUserId()),
                loanDto.getLoanDate(),
                loanDto.getReturnDate());
    }
    public LoanDto mapToLoanDto(Loan loan) {
        return new LoanDto(loan.getId(),
                loan.getBook().getId(),
                loan.getUser().getId(),
                loan.getLoanDate(),
                loan.getReturnDate());
    }
}
