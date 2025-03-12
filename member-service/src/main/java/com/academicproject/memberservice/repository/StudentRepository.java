package com.academicproject.memberservice.repository;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    Student findStudentByStudentId(String studentId);
}
