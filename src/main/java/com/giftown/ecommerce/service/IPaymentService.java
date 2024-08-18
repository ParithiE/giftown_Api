package com.giftown.ecommerce.service;

import com.giftown.ecommerce.entity.Payment;

public interface IPaymentService {
    Payment processCashOnDeliveryPayment(Long orderId, Double amount);
    Payment updatePaymentStatus(Long paymentId, String status);
    Payment getPaymentById(Long paymentId);
    Payment getPaymentsByOrderId(Long orderId);
}
