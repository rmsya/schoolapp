package com.academicproject.memberservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {

    @NotNull (message = "student name is mandatory")
    private String fullName;

    @NotNull (message = "gender is mandatory")
    @Pattern(regexp = "Male|Female", message = "gender must be 'Male' or 'Female'")
    private String gender;

    @NotNull (message = "birthdate is mandatory")
    private LocalDate birthDate;

    @NotNull (message = "grade is mandatory")
    @Pattern(regexp = "^(1[0-2]|[1-9])$", message = "grade must be between 1 and 12")
    private String grade;

    @NotNull (message = "parent name is mandatory")
    private String parentName;

    @NotNull (message = "parent phone is mandatory")
    @Pattern(regexp = "^[08]{2}[0-9]{9}$")
    private String parentPhone;

}
