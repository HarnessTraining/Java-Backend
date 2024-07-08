package com.virtusa.project.PgRental.service.impl;

import com.virtusa.project.PgRental.dao.PaymentTransactionDao;
import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.service.PaymentTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTransactionsServiceImpl implements PaymentTransactionsService {

    @Autowired
    PaymentTransactionDao paymentTransactionDao;
    @Override
    public List<PaymentTransactionsDto> getAllTransactions() {
       return paymentTransactionDao.getAllTransaction();
    }

//    @Override
//    public Optional<PaymentTransactionsDto> getTransactionById(Long id) {
//        return paymentTransactionDao.getTransactionById(id);
//    }
//
    @Override
    public PaymentTransactionsDto createTransaction(PaymentTransactionsDto paymentTransactionsDTO) {
        return paymentTransactionDao.createTransaction(paymentTransactionsDTO);
    }

}
