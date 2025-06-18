package com.scaler.paymentservice12apr.repositories;

import com.scaler.paymentservice12apr.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment save(Payment payment);

    Payment findByPaymentGatewayReferenceId(String paymentGatewayReferenceId);
}
