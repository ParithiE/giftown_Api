package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.Payment.PaymentRequestModel;
import com.giftown.ecommerce.dto.Payment.PaymentResponseModel;
import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.dto.order.OrderResponseModel;
import com.giftown.ecommerce.service.IOrderService;
import com.giftown.ecommerce.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class PaymentMapper {

    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private IPaymentService paymentService;

    public PaymentResponseModel processCashOnDeliveryPayment(Long orderId,  Double amount) {
        return commonMapper.convertToEntity(paymentService.processCashOnDeliveryPayment(orderId, amount), PaymentResponseModel.class);
    }

    public PaymentResponseModel getPaymentById(Long paymentId) {
        return commonMapper.convertToEntity(paymentService.getPaymentById(paymentId), PaymentResponseModel.class);
    }

    public PaymentResponseModel getPaymentsByOrderId(Long orderId) {
        return commonMapper.convertToEntity(paymentService.getPaymentsByOrderId(orderId), PaymentResponseModel.class);
    }

    public PaymentResponseModel updatePaymentStatus(Long paymentId,  String status) {
        return commonMapper.convertToEntity(paymentService.updatePaymentStatus(paymentId, status), PaymentResponseModel.class);

    }
}
