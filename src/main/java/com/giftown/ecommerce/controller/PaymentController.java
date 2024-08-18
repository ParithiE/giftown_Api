package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.Payment.PaymentResponseModel;
import com.giftown.ecommerce.entity.Payment;
import com.giftown.ecommerce.mapper.PaymentMapper;
import com.giftown.ecommerce.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.giftown.ecommerce.constants.PathConstants.*;


@RestController
@RequestMapping(PAYMENT)
public class PaymentController {
    @Autowired
    private PaymentMapper paymentMapper;


    @PostMapping(PAYMENT_COD)
    public ResponseEntity<PaymentResponseModel> cashOnDeliveryPayment(@RequestParam Long orderId, @RequestParam Double amount) {
        PaymentResponseModel payment = paymentMapper.processCashOnDeliveryPayment(orderId, amount);
        return ResponseEntity.ok(payment);
    }

    @PutMapping(PAYMENT_STATUS)
    public ResponseEntity<PaymentResponseModel> updatePaymentStatus(@PathVariable Long paymentId, @RequestParam String status) {
        PaymentResponseModel payment = paymentMapper.updatePaymentStatus(paymentId, status);
        return ResponseEntity.ok(payment);
    }


    @GetMapping(PAYMENT_ID)
    public ResponseEntity<PaymentResponseModel> getPaymentById(@PathVariable Long paymentId) {
        return ResponseEntity.ok(paymentMapper.getPaymentById(paymentId));
    }

    @GetMapping(PAYMENT_ORDERID)
    public ResponseEntity<PaymentResponseModel> getPaymentsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentMapper.getPaymentsByOrderId(orderId));
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<PaymentResponseModel>> getPaymentsByUserId(@PathVariable Long userId) {
//        List<Payment> payments = paymentService.getPaymentsByUserId(userId);
//        List<PaymentResponseModel> paymentResponses = payments.stream()
//                .map(paymentMapper::toPaymentResponse)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(paymentResponses);
//    }

}
