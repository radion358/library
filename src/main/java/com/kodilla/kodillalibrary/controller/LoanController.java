package com.kodilla.kodillalibrary.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @PostMapping
    public void loanBook(@RequestParam long userId, @RequestParam long bookId) {

    }

    @PatchMapping
    public void returnBook(@RequestParam long loanId) {

    }
}
