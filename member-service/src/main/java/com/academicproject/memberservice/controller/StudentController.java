package com.academicproject.memberservice.controller;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.dto.request.CreateStudentRequest;
import com.academicproject.memberservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Void> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        studentService.createStudent(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getStudents(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String gender,
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {

        Page<StudentDTO> students = studentService.getStudents(studentId, firstName, gender, pageable);
        return ResponseEntity.ok(students);
    }
}
