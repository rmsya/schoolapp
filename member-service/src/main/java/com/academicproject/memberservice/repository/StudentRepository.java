package com.academicproject.memberservice.repository;

import com.academicproject.memberservice.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
