package com.example.DemoOfAOP;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void makePayment() {
        // payment code
        System.out.println("Amount Debited...");
        /// ///////////
        System.out.println("Amount Credited...");

    }
}
