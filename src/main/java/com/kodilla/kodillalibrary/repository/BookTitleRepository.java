package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {
}
