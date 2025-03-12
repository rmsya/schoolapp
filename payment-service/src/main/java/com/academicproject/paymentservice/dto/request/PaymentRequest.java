package com.academicproject.paymentservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotNull (message = "student id is mandatory")
    private String studentId;

    @NotNull (message = "year is mandatory")
    private String year;

    private String month;

    @NotNull (message = "payment type is mandatory")
    private String type;

    @NotNull (message = "payment method is mandatory")
    private String paymentMethod;

    @NotNull (message = "amount is mandatory")
    private BigDecimal amount;

}
