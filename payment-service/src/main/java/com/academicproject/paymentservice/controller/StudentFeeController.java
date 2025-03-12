package com.academicproject.paymentservice.controller;

import com.academicproject.paymentservice.dto.request.PaymentRequest;
import com.academicproject.paymentservice.dto.response.GetStudentBillingResponse;
import com.academicproject.paymentservice.service.StudentFeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student-fee")
public class StudentFeeController {

    @Autowired
    private StudentFeeService studentFeeService;

    @PostMapping("/pay")
    public ResponseEntity<Void> pay(@Valid @RequestBody PaymentRequest request) {
        studentFeeService.processPayment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-billing")
    public ResponseEntity<GetStudentBillingResponse> getBilling(
            @RequestParam String studentId,
            @RequestParam String billingType) {
        GetStudentBillingResponse response = new GetStudentBillingResponse();
        response.setBilling(studentFeeService.getBilling(studentId, billingType));
        return ResponseEntity.ok(response);
    }


}
