package com.giftown.ecommerce.dto.Payment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponseModel {
        private Long paymentId;
        private Long orderId;
        private Long userId;
        private String paymentType;
        private Double amount;
        private String paymentStatus;
        private LocalDateTime createdAt;
    }
