package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private long id;
    private long bookId;
    private long userId;
    private Date loanDate;
    private Date returnDate;
}
