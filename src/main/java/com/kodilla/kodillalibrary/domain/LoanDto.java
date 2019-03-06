package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private long id;
    private long bookId;
    private long userId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanDto loanDto = (LoanDto) o;

        if (id != loanDto.id) return false;
        if (bookId != loanDto.bookId) return false;
        if (userId != loanDto.userId) return false;
        if (!Objects.equals(loanDate, loanDto.loanDate)) return false;
        return Objects.equals(returnDate, loanDto.returnDate);
    }
}
