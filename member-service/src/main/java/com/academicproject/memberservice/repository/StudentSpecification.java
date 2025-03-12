package com.academicproject.memberservice.repository;

import com.academicproject.memberservice.domain.entity.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StudentSpecification {

    public static Specification<Student> filterBy(String studentId, String fullName, String gender) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // If studentId is provided, apply LIKE filter
            if (studentId != null && !studentId.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("studentId")), "%" + studentId.toLowerCase() + "%"));
            }

            // If fullName is provided, apply LIKE filter
            if (fullName != null && !fullName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%" + fullName.toLowerCase() + "%"));
            }

            // If gender is provided, apply EQUALS filter
            if (gender != null && !gender.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), gender));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
