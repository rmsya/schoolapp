package com.academicproject.paymentservice.service.impl;

import com.academicproject.paymentservice.domain.entity.StMonthlyFeeOrder;
import com.academicproject.paymentservice.domain.enums.PaymentType;
import com.academicproject.paymentservice.dto.BillingDTO;
import com.academicproject.paymentservice.dto.StudentDTO;
import com.academicproject.paymentservice.dto.request.PaymentRequest;
import com.academicproject.paymentservice.factory.PaymentStrategyFactory;
import com.academicproject.paymentservice.feign.MemberServiceClient;
import com.academicproject.paymentservice.repository.StMonthlyFeeOrderRepository;
import com.academicproject.paymentservice.repository.StudentFeeRepository;
import com.academicproject.paymentservice.service.StudentFeeService;
import com.academicproject.paymentservice.strategy.PaymentStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class StudentFeeServiceImpl implements StudentFeeService {

    @Autowired
    private PaymentStrategyFactory paymentStrategyFactory;

    @Autowired
    private StMonthlyFeeOrderRepository stMonthlyFeeOrderRepository;

    @Autowired
    private StudentFeeRepository studentFeeRepository;

    @Autowired
    private MemberServiceClient memberServiceClient;

    @Override
    public void processPayment(PaymentRequest paymentRequest) {

        PaymentStrategy strategy = paymentStrategyFactory.getPaymentStrategy(paymentRequest.getType());
        if (strategy != null) {
            strategy.processPayment(paymentRequest);
        } else {
            throw new IllegalArgumentException("Invalid payment type: " + paymentRequest.getType());
        }

    }

    @Override
    public BillingDTO getBilling(String studentId, String billingType) {
        BillingDTO billingDTO = new BillingDTO();
        if (StringUtils.equals(billingType, PaymentType.MONTHLY.name())) {
            StMonthlyFeeOrder stMonthlyFeeOrder = stMonthlyFeeOrderRepository.findTopByStudentIdOrderByTransactionIdDesc(studentId);

            if (stMonthlyFeeOrder == null) {
                return billingDTO;
            }
            billingDTO = fillNewBillingInformation(stMonthlyFeeOrder);

        } else if (StringUtils.equals(billingType, PaymentType.ANNUALLY.name()) || StringUtils.equals(billingType, PaymentType.SEMESTER.name())) {
            System.out.print("not supported yet");
        } else {
            throw new IllegalArgumentException("Invalid type: " + billingType);
        }

        return billingDTO;
    }

    private BillingDTO fillNewBillingInformation(StMonthlyFeeOrder latestBilling) {
        BillingDTO billingDTO = new BillingDTO();
        billingDTO.setStudentId(latestBilling.getStudentId());
        billingDTO.setType(latestBilling.getType());

        YearMonth nextMonth = YearMonth.of(latestBilling.getYear(), latestBilling.getMonth()).plusMonths(1);
        billingDTO.setYear(String.valueOf(nextMonth.getYear()));
        billingDTO.setMonth(nextMonth.getMonth().name());

        StudentDTO studentDTO = memberServiceClient.getStudentById(latestBilling.getStudentId());
        billingDTO.setDueAmount(studentFeeRepository.findByGrade(studentDTO.getGrade()).getAmount());

        return billingDTO;
    }
}
