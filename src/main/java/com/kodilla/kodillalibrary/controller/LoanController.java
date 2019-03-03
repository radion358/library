package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.LoanDto;
import com.kodilla.kodillalibrary.mapper.LoanMapper;
import com.kodilla.kodillalibrary.service.BookService;
import com.kodilla.kodillalibrary.service.LoanService;
import com.kodilla.kodillalibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;
    private final LoanMapper mapper;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public LoanController(LoanService loanService, LoanMapper mapper, BookService bookService, UserService userService) {
        this.loanService = loanService;
        this.mapper = mapper;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping
    public LoanDto loanBook(@RequestParam long userId, @RequestParam long bookId) {
        return mapper.mapToLoanDto(loanService
                .addLoan(bookService.findBookById(bookId), userService.findUserById(userId)));
    }

    @PatchMapping
    public LoanDto updateBookStatus(@RequestBody BookDto bookDto, @RequestParam long loanId) {
        if (bookDto.getStatus().equals(Book.AVAILABLE)) {
            return mapper.mapToLoanDto(loanService.returnLoanedBook(loanId));
        }
        return mapper.mapToLoanDto(loanService.findLoanById(loanId));
    }
}
