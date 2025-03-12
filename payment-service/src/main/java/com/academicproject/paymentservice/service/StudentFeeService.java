package com.academicproject.paymentservice.service;

import com.academicproject.paymentservice.dto.BillingDTO;
import com.academicproject.paymentservice.dto.request.PaymentRequest;
import com.academicproject.paymentservice.dto.response.GetStudentBillingResponse;

public interface StudentFeeService {

    void processPayment(PaymentRequest paymentRequest);

    BillingDTO getBilling(String studentId, String billingType);
}
