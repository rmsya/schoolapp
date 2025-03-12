package com.academicproject.paymentservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String fullName;

    private String gender;

    private LocalDate birthDate;

    private String grade;

    private String parentName;

    private String parentPhone;
}
