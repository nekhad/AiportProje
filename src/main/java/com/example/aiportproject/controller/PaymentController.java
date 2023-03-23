package com.example.aiportproject.controller;
import com.example.aiportproject.entity.Payment;
import com.example.aiportproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayments();
    }

    @PostMapping("/")
    public void createPayment(@RequestBody Payment payment) {
        paymentService.createPayment(payment);
    }
    @PutMapping("/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        paymentService.updatePaymentDetails(id, payment);
    }
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePaymentDetails(id);
    }
}
