package com.academicproject.paymentservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyFeePaymentResponse {

    private String transactionId;

    private String studentId;

    private String status;

}
