package com.example.aiportproject.service;

import com.example.aiportproject.entity.Passenger;
import com.example.aiportproject.entity.Payment;
import com.example.aiportproject.repository.PassengerRepository;
import com.example.aiportproject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void createPayment(Payment Payment) {
        paymentRepository.save(Payment);
    }

    public void updatePaymentDetails(Long id, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            payment.setId(id);
            paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment not found");
        }
    }

    public void deletePaymentDetails(Long id) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            paymentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Payment not found");
        }
    }
}

