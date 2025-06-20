package com.payments.paymentservice.paymentgateways;

import com.payments.paymentservice.models.PaymentStatus;

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
