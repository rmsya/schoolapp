package com.academicproject.memberservice.dto;

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

    @NotNull
    private String fullName;

    @NotNull
    private String gender;

    @NotNull
    private String grade;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String parentName;

    @NotNull
    @Pattern(regexp = "^[08]{2}[0-9]{9}$")
    private String parentPhone;

    @NotNull
    private String status;
}
