package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.model.Booking;
import com.virtusa.project.PgRental.model.PaymentTransactions;
import com.virtusa.project.PgRental.repository.BookingRepository;
import com.virtusa.project.PgRental.repository.PaymentTransactionsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional // Ensure that all methods in this DAO are wrapped in a transaction
public class PaymentTransactionDao {

    @Autowired
    private PaymentTransactionsRepo paymentTransactionsRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PaymentTransactionsDto> getAllTransaction() {
        return (List<PaymentTransactionsDto>) modelMapper.map(paymentTransactionsRepository.findAll(),PaymentTransactions.class);
    }

    public PaymentTransactionsDto getTransactionById(Long id) {
        PaymentTransactions paymentTransaction = paymentTransactionsRepository.findById(id).get();
        return modelMapper.map(paymentTransaction,PaymentTransactionsDto.class);
    }

    public PaymentTransactionsDto createTransaction(PaymentTransactionsDto paymentTransactionsDTO) {
        try {
            Optional<Booking> bookingOptional = bookingRepository.findById(paymentTransactionsDTO.getBookingId());
            if (!bookingOptional.isPresent()) {
                throw new RuntimeException("Booking not found");
            }
            Booking booking = bookingOptional.get();

            // Convert DTO to entity
            PaymentTransactions transaction = modelMapper.map(paymentTransactionsDTO, PaymentTransactions.class);

            // Save the transaction
            PaymentTransactions paymentTransactions = paymentTransactionsRepository.save(transaction);
            return modelMapper.map(paymentTransactions,PaymentTransactionsDto.class);
        } catch (Exception e) {
            // Consider logging the exception for debugging purposes
            throw new RuntimeException("Failed to create transaction", e);
        }
    }
}
