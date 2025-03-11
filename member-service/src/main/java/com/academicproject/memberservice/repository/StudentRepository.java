package com.academicproject.memberservice.repository;

import com.academicproject.memberservice.domain.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("SELECT s FROM Student s WHERE "
            + "(:studentId IS NULL OR LOWER(s.studentId) LIKE LOWER(CONCAT('%', :studentId, '%'))) "
            + "AND (:fullName IS NULL OR LOWER(s.fullName) LIKE LOWER(CONCAT('%', :fullName, '%'))) "
            + "AND (:gender IS NULL OR s.gender = :gender)")
    Page<Student> findStudents(@Param("studentId") String studentId,
                               @Param("fullName") String fullName,
                               @Param("gender") String gender,
                               Pageable pageable);

}
