package com.virtusa.project.PgRental.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.PaymentTransactionDao;
import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.model.PaymentTransactions;
import com.virtusa.project.PgRental.service.PaymentTransactionsService;

@Service
public class PaymentTransactionsServiceImpl implements PaymentTransactionsService {

    @Autowired
    PaymentTransactionDao paymentTransactionDao;
    @Override
    public List<PaymentTransactions> getAllTransactions() {
       return paymentTransactionDao.getAllTransaction();
    }

    @Override
    public Optional<PaymentTransactions> getTransactionById(Long id) {
        return paymentTransactionDao.getTransactionById(id);
    }
    
    @Override
    public PaymentTransactions createTransaction(PaymentTransactionsDto paymentTransactionsDTO) {
        return paymentTransactionDao.createTransaction(paymentTransactionsDTO);
    }

}
