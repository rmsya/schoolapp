package com.academicproject.memberservice.controller;

import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Void> createStudent(@Valid StudentDTO request) {
        studentService.createStudent(request);
        return ResponseEntity.ok().build();
    }
}
