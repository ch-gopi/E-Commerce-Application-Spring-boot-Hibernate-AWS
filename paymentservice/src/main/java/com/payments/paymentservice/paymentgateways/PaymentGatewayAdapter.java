package com.scaler.paymentservice.adapters.paymentgatewaysadapters;

public interface PaymentGatewayAdapter {

    String createPaymentLink(Long price) throws Exception;
}
