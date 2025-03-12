package com.academicproject.paymentservice.factory;

import com.academicproject.paymentservice.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentStrategyFactory(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public PaymentStrategy getPaymentStrategy(String type) {
        return paymentStrategies.get(type.toLowerCase() + "PaymentStrategy");
    }
}
