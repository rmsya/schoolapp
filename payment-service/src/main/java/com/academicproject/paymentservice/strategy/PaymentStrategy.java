package com.academicproject.paymentservice.strategy;

import com.academicproject.paymentservice.dto.request.PaymentRequest;

public interface PaymentStrategy {
    void processPayment(PaymentRequest paymentRequest);
}
