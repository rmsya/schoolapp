package com.academicproject.memberservice.service.impl;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.dto.request.CreateStudentRequest;
import com.academicproject.memberservice.repository.StudentRepository;
import com.academicproject.memberservice.service.StudentService;
import com.academicproject.memberservice.util.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(CreateStudentRequest newStudent) {

        Student student = new Student();
        student.setStudentId(CommonHelper.generateId("ST"));
        student.setFullName(newStudent.getFullName());
        student.setGender(newStudent.getGender());
        student.setBirthDate(newStudent.getBirthDate());
        student.setParentName(newStudent.getParentName());
        student.setParentPhone(newStudent.getParentPhone());

        studentRepository.save(student);
    }

    @Override
    public Page<StudentDTO> getStudents(String studentId, String fullName, String gender, Pageable pageable) {
        studentRepository.findStudents(studentId, fullName, gender, pageable);
    }
}
