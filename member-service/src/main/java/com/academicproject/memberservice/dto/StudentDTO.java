package com.academicproject.memberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String studentId;

    private String fullName;

    private String gender;

    private String grade;

    private LocalDate birthDate;

    private String parentName;

    private String parentPhone;

    private String status;
}
