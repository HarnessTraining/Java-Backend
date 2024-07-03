package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;

import java.util.List;

public interface PaymentTransactionsService {
    List<PaymentTransactionsDto> getAllTransactions();

//    Optional<PaymentTransactionsDto> getTransactionById(Long id);

    PaymentTransactionsDto createTransaction(PaymentTransactionsDto paymentTransactionsDTO);
}
