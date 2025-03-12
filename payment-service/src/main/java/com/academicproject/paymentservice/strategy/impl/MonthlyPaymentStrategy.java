package com.academicproject.paymentservice.strategy.impl;

import com.academicproject.paymentservice.domain.entity.StMonthlyFeeOrder;
import com.academicproject.paymentservice.dto.request.PaymentRequest;
import com.academicproject.paymentservice.mapper.StMonthlyFeeOrderMapper;
import com.academicproject.paymentservice.repository.StMonthlyFeeOrderRepository;
import com.academicproject.paymentservice.strategy.PaymentStrategy;
import com.academicproject.paymentservice.util.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("monthlyPaymentStrategy")
public class MonthlyPaymentStrategy implements PaymentStrategy {

    @Autowired
    private StMonthlyFeeOrderRepository stMonthlyFeeOrderRepository;

    @Override
    public void processPayment(PaymentRequest paymentRequest) {

        StMonthlyFeeOrder stMonthlyFeeOrder = StMonthlyFeeOrderMapper.INSTANCE.toEntity(paymentRequest);
        stMonthlyFeeOrder.setTransactionId(CommonHelper.generateId("TRX-"));
        stMonthlyFeeOrderRepository.save(stMonthlyFeeOrder);
    }
}
