package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.PgRental.model.PaymentTransactions;

public interface PaymentTransactionsRepo extends JpaRepository<PaymentTransactions,String> {

}

