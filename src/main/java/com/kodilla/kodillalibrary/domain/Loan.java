package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    private long id;
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, User user, LocalDate loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    @Column
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
