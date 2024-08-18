package com.giftown.ecommerce.repository;

import com.giftown.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRespository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long orderId);
}
