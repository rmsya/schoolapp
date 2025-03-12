package com.academicproject.paymentservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "student_fee")
@Getter
@Setter
public class StudentFee {

    @Id
    private Long id;

    private String grade;

    private BigDecimal amount;

    private String type;
}
