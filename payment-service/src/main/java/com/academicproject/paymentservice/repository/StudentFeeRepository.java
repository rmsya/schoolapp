package com.academicproject.paymentservice.repository;

import com.academicproject.paymentservice.domain.entity.StudentFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFee, Long> {

    StudentFee findByGrade(String grade);

}
