package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.model.PaymentTransactions;
import com.virtusa.project.PgRental.service.PaymentTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment-transactions")
public class PaymentTransactionsController {

    @Autowired
    private PaymentTransactionsService paymentTransactionsService;

    @GetMapping
    public ResponseEntity<List<PaymentTransactions>> getAllTransactions() {
        List<PaymentTransactions> transactions = paymentTransactionsService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactions> getTransactionById(@PathVariable Long id) {
        Optional<PaymentTransactions> transaction = paymentTransactionsService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPaymentTransaction(@RequestBody PaymentTransactionsDto paymentTransactionsDto) {
        try {
            PaymentTransactions transaction = paymentTransactionsService.createTransaction(paymentTransactionsDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("Booking not found")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found with ID: " + paymentTransactionsDto.getBookingId());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create transaction: " + e.getMessage());
        }
    }
}
