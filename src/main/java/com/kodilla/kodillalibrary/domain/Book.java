package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    private long id;
    private BookTitle bookTitle;
    private String status;
    public final static String LOANED = "LOANED";
    public final static String LOST = "LOST";
    public final static String DAMAGED = "DAMAGED";
    public final static String AVAILABLE = "AVAILABLE";

    @Id
    @GeneratedValue
    @NotNull
    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Column
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
