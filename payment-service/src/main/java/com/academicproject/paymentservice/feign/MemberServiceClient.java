package com.academicproject.paymentservice.feign;

import com.academicproject.paymentservice.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url = "http://localhost:8081")
public interface MemberServiceClient {

    @GetMapping("/api/v1/student/get-detail?studentId={studentId}")
    StudentDTO getStudentById(@PathVariable String studentId);
}
