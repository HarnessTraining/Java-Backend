package com.virtusa.project.PgRental.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.virtusa.project.PgRental.dto.PaymentTransactionsDto;
import com.virtusa.project.PgRental.service.BookingService;
import com.virtusa.project.PgRental.service.PaymentTransactionsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment-transactions")
public class PaymentTransactionsController {

    @Autowired
    private PaymentTransactionsService paymentTransactionsService;

    @Autowired
    private BookingService bookingService;

//    @GetMapping
//    public ResponseEntity<List<PaymentTransactions>> getAllTransactions() {
//        List<PaymentTransactions> transactions = paymentTransactionsService.getAllTransactions();
//        return ResponseEntity.ok(transactions);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PaymentTransactions> getTransactionById(@PathVariable Long id) {
//        Optional<PaymentTransactionsDto> transaction = paymentTransactionsService.getTransactionById(id);
//        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    @PostMapping("/save")
//    public ResponseEntity<Object> createPaymentTransaction(@RequestBody PaymentTransactionsDto paymentTransactionsDto) {
//        try {
//            // Create payment transaction
////            PaymentTransactions transaction = paymentTransactionsService.createTransaction(paymentTransactionsDto);
////
////            // Update booking status to confirmed
////            BookingDto booking = bookingService.getBookingDetails(paymentTransactionsDto.getBookingId());
////            if (booking != null) {
////                booking.setConfirmed(true);
////                bookingService.updateBooking(booking);
////            } else {
////                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found with ID: " + paymentTransactionsDto.getBookingId());
////            }
//            PaymentTransactionsDto transaction = paymentTransactionsService.createTransaction(paymentTransactionsDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
//        } catch (RuntimeException e) {
//            if (e.getMessage().equals("Booking not found")) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found with ID: " + paymentTransactionsDto.getBookingId());
//            }
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create transaction: " + e.getMessage());
//        }
//    }

    @PostMapping("/save")
    public ResponseEntity<String> savePaymentTransaction(@RequestBody PaymentTransactionsDto paymentTransactionsDto) {
        try {
            bookingService.savePaymentTransaction(paymentTransactionsDto.getBookingId(), paymentTransactionsDto.getPaymentId());
            return ResponseEntity.ok("Payment transaction saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving payment transaction.");
        }
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody Map<String,Object>data){
        System.out.println(data);

        int amount = Integer.parseInt(data.get("amount").toString());
        Order order = null;
        try {
            RazorpayClient client =new RazorpayClient("rzp_test_KeMyxfEpF0whU9","ar9WdXADdhi5HfBYbS1ykmUP");
            JSONObject ob = new JSONObject();
            ob.put("amount",amount*100);
            ob.put("currency","INR");
            ob.put("receipt","txn_234343");

            order = client.Orders.create(ob);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return order.toString();
    }



}
