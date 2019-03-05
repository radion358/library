package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private long id;
    private long bookId;
    private long userId;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
