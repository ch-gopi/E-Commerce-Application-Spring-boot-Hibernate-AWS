package com.payments.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks/razorpay")
public class RazorpayWebhookController {

    @PostMapping
    public void handleWebhookEvent() {
        System.out.println("hi");
    }
}
