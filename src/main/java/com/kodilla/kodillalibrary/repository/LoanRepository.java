package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
}
