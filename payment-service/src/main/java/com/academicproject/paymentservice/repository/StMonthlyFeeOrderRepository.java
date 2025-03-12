package com.academicproject.paymentservice.repository;

import com.academicproject.paymentservice.domain.entity.StMonthlyFeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StMonthlyFeeOrderRepository extends JpaRepository<StMonthlyFeeOrder, String> {

    StMonthlyFeeOrder findTopByStudentIdOrderByTransactionIdDesc (String studentId);

}
