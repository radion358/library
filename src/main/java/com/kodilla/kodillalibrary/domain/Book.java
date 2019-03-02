package com.kodilla.kodillalibrary.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    @Column
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
