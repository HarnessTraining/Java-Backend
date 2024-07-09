package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.PaymentTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentTransactionsRepo extends JpaRepository<PaymentTransactions, Long> {

}

