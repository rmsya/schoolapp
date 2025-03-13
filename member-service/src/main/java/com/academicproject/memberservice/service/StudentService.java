package com.academicproject.memberservice.service;

import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.dto.request.CreateStudentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    StudentDTO createStudent(CreateStudentRequest createStudentRequest);

    Page<StudentDTO> getStudents(String studentId, String fullName, String gender, Pageable pageable);

    StudentDTO getStudentDetail(String studentId);

}
