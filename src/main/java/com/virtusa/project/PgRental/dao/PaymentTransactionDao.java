package com.virtusa.project.PgRental.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.model.Booking;
import com.virtusa.project.PgRental.model.PaymentTransactions;
import com.virtusa.project.PgRental.repository.BookingRepository;
import com.virtusa.project.PgRental.repository.PaymentTransactionsRepo;

@Repository
@Transactional // Ensure that all methods in this DAO are wrapped in a transaction
public class PaymentTransactionDao {

    @Autowired
    private PaymentTransactionsRepo repository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PaymentTransactions> getAllTransaction() {
        return repository.findAll();
    }

    public Optional<PaymentTransactions> getTransactionById(Long id) {
        return repository.findById(id);
    }

    public PaymentTransactions createTransaction(PaymentTransactionsDto paymentTransactionsDTO) {
        try {
            Optional<Booking> bookingOptional = bookingRepository.findById(paymentTransactionsDTO.getBookingId());
            if (!bookingOptional.isPresent()) {
                throw new RuntimeException("Booking not found");
            }
            Booking booking = bookingOptional.get();

            // Convert DTO to entity
            PaymentTransactions transaction = modelMapper.map(paymentTransactionsDTO, PaymentTransactions.class);
            transaction.setBooking(booking);

            // Save the transaction
            return repository.save(transaction);
        } catch (Exception e) {
            // Consider logging the exception for debugging purposes
            throw new RuntimeException("Failed to create transaction", e);
        }
    }
}
