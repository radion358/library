package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    private long id;
    private String name;
    private String surname;
    private LocalDate userSignUpDate;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column
    public LocalDate getUserSignUpDate() {
        return userSignUpDate;
    }

    public void setUserSignUpDate(LocalDate userSignUpDate) {
        this.userSignUpDate = userSignUpDate;
    }


}
