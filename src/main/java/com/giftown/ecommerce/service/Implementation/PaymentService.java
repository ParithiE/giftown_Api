package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.constants.Constant;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.Payment;
import com.giftown.ecommerce.exception.ApiRequestException;
import com.giftown.ecommerce.repository.OrderRepository;
import com.giftown.ecommerce.repository.PaymentRespository;
import com.giftown.ecommerce.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.giftown.ecommerce.constants.ErrorMessage.ORDER_NOT_FOUND;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRespository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment processCashOnDeliveryPayment(Long orderId, Double amount) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = new Payment();
//        payment.setUser(user);
        payment.setOrder(order);
        payment.setPaymentType(Constant.COD);
        payment.setAmount(amount);
        payment.setPaymentStatus(Constant.PENDING);
        payment.setCreatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public Payment updatePaymentStatus(Long paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setPaymentStatus(status);
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public Payment getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

//    public List<Payment> getPaymentsByUserId(Long userId) {
//        return paymentRepository.findByUserId(userId);
//    }
}
