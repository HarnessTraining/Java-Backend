package com.virtusa.project.PgRental.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.model.PaymentTransactions;

public interface PaymentTransactionsService {
    List<PaymentTransactions> getAllTransactions();

    Optional<PaymentTransactions> getTransactionById(Long id);

    PaymentTransactions createTransaction(PaymentTransactionsDto paymentTransactionsDTO);
}
