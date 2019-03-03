package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.LoanDto;
import com.kodilla.kodillalibrary.exception.BookNotFoundExceptin;
import com.kodilla.kodillalibrary.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoanMapper(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Loan mapToLoan(LoanDto loanDto) {
        return new Loan(loanDto.getId(),
                bookRepository.findById(loanDto.getBookId()).orElseThrow(BookNotFoundExceptin::new),
                userRepository.findById(loanDto.getUserId()).orElseThrow(UserNotFoundException::new),
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
