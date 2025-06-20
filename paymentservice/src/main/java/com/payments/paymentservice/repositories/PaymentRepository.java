package com.payments.paymentservice.repositories;

import com.payments.paymentservice.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment save(Payment payment);

    Payment findByPaymentGatewayReferenceId(String paymentGatewayReferenceId);
}
