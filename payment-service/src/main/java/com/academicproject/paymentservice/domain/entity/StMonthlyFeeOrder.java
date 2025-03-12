package com.academicproject.paymentservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "st_monthly_fee_order")
@Getter
@Setter
public class StMonthlyFeeOrder extends BaseEntity {

    @Id
    private String transactionId;

    private String studentId;

    private int month;

    private int year;

    private String type;

    private String paymentMethod;

    private BigDecimal amount;

}

