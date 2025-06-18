package com.scaler.paymentservice12apr.services;

import com.scaler.paymentservice12apr.models.Payment;
import com.scaler.paymentservice12apr.models.PaymentGateway;
import com.scaler.paymentservice12apr.models.PaymentStatus;
import com.scaler.paymentservice12apr.paymentgateways.PaymentGatewayFactory;
import com.scaler.paymentservice12apr.paymentgateways.PaymentGatewayInterface;
import com.scaler.paymentservice12apr.paymentgateways.RazorpayPaymentGateway;
import com.scaler.paymentservice12apr.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private PaymentGatewayFactory paymentGatewayFactory;
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentGatewayFactory paymentGatewayFactory, PaymentRepository paymentRepository, RazorpayPaymentGateway razorpayPaymentGateway) {
        this.paymentGatewayFactory = paymentGatewayFactory;
        this.paymentRepository = paymentRepository;
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public String createPaymentLink(Long orderId) {
        // I need to get the details of the order:
        //      - amount

        // Order order = restTemplate.getForObject("", Order.class);
        // Long amount = order.getAmount();
        // String userName = order.getUser().getName();
        // String userMobile = order.getUser().getPhoneNumber();
        // String userEmail = order.getUser().getEmail();

        Long amount = 1000L;
        String userName = "Naman Bhalla";
        String userMobile = "+919999999999";
        String userEmail = "abc@example.com";

        PaymentGatewayInterface paymentGateway = paymentGatewayFactory.getBestPaymentGateway();

        String paymentLink = paymentGateway.createPaymentLink(
                amount, userName, userEmail, userMobile, orderId
        );

        Payment payment = new Payment();
        payment.setPaymentLink(paymentLink);
        payment.setOrderId(orderId);
        payment.setPaymentGateway(PaymentGateway.RAZORPAY);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setAmount(amount);

        paymentRepository.save(payment);

        return paymentLink;

    }

    public PaymentStatus getPaymentStatus(String paymentGatewayPaymentId) {

        Payment payment = paymentRepository.findByPaymentGatewayReferenceId(paymentGatewayPaymentId);
        PaymentGatewayInterface paymentGateway = null;

        if (payment.getPaymentGateway().equals(PaymentGateway.RAZORPAY)) {
            paymentGateway = razorpayPaymentGateway;
        }

        PaymentStatus paymentStatus = paymentGateway.getPaymentStatus(paymentGatewayPaymentId);;

        payment.setPaymentStatus(paymentStatus);

        paymentRepository.save(payment);

        return paymentStatus;
    }
}
