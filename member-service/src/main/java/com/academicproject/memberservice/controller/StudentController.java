package com.academicproject.memberservice.controller;

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
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        StudentDTO studentDTO = studentService.createStudent(request);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Page<StudentDTO>> getStudents(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String gender,
            @PageableDefault(size = 10, sort = "fullName") Pageable pageable) {

        Page<StudentDTO> students = studentService.getStudents(studentId, fullName, gender, pageable);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get-detail")
    public ResponseEntity<StudentDTO> getStudentDetail(
            @RequestParam String studentId) {
        StudentDTO student = studentService.getStudentDetail(studentId);
        return ResponseEntity.ok(student);
    }
}
