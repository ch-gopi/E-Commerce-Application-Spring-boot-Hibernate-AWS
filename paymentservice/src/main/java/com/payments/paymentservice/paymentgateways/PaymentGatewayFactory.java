package com.payments.paymentservice.paymentgateways;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayFactory {
    private RazorpayPaymentGateway razorpayPaymentGateway;

    public PaymentGatewayFactory(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public PaymentGatewayInterface getBestPaymentGateway() {

//        int random = new Random().nextInt();
//
//        if (random % 2 == 0) return new RazorpayPaymentGateway();
//
//        return new StripePaymentGateway();
        return razorpayPaymentGateway;
    }
}
