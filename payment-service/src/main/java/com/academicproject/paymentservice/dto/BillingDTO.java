package com.academicproject.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDTO {
    private String studentId;
    private String type;
    private BigDecimal dueAmount;
    private String month;
    private String year;
}
