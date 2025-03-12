package com.academicproject.memberservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends BaseEntity {

    @Id
    private String studentId;

    private String fullName;

    private LocalDate birthDate;

    private String gender;

    private String grade;

    private String parentName;

    private String parentPhone;

    private String status;

}
