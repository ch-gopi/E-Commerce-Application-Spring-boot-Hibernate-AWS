package com.scaler.paymentservice12apr.paymentgateways;

import com.scaler.paymentservice12apr.models.PaymentStatus;

public interface PaymentGatewayInterface {

    String createPaymentLink(
            Long amount,
            String userName,
            String userEmail,
            String userPhone,
            Long orderId
    );

    PaymentStatus getPaymentStatus(
            String paymentId
    );
}
