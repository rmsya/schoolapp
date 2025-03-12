package com.academicproject.memberservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotNull
    private String studentId;

    @NotNull
    private String year;

    private String month;

    @NotNull
    private String type;

    @NotNull
    private String paymentMethod;

    @NotNull
    private BigDecimal amount;

}
