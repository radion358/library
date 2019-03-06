package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;
    private BookTitleDto bookTitleDto;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (id != bookDto.id) return false;
        if (!Objects.equals(bookTitleDto, bookDto.bookTitleDto))
            return false;
        return Objects.equals(status, bookDto.status);
    }
}
