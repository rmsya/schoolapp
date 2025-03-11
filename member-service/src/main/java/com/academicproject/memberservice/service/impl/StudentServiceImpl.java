package com.academicproject.memberservice.service.impl;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.repository.StudentRepository;
import com.academicproject.memberservice.service.StudentService;
import com.academicproject.memberservice.util.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(StudentDTO newStudent) {

        Student student = new Student();
        student.setStudentId(CommonHelper.generateId("ST"));
        student.setFullName(newStudent.getFirstName());
        student.setBirthDate(newStudent.getBirthDate());
        student.setParentName(newStudent.getParentName());
        student.setParentPhone(newStudent.getParentPhone());

        studentRepository.save(student);

    }
}
