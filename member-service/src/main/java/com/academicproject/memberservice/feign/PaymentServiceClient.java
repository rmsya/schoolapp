package com.academicproject.memberservice.feign;

import com.academicproject.memberservice.dto.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "http://localhost:8082")
public interface PaymentServiceClient {

    @PostMapping("/api/v1/student-fee/pay")
    void pay(@RequestBody PaymentRequest paymentRequest);
}
