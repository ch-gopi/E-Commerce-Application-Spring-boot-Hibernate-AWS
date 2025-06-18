package com.scaler.paymentservice12apr.paymentgateways;

import com.scaler.paymentservice12apr.models.PaymentStatus;

public class StripePaymentGateway implements PaymentGatewayInterface {

    @Override
    public String createPaymentLink(Long amount, String userName, String userEmail, String userPhone, Long orderId) {
        return "";
    }

    @Override
    public PaymentStatus getPaymentStatus(String paymentId) {
        return null;
    }
}
