package com.academicproject.memberservice.service.impl;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.domain.enums.PaymentMethod;
import com.academicproject.memberservice.domain.enums.StudentPaymentType;
import com.academicproject.memberservice.domain.enums.StudentStatus;
import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.dto.request.CreateStudentRequest;
import com.academicproject.memberservice.dto.request.PaymentRequest;
import com.academicproject.memberservice.feign.PaymentServiceClient;
import com.academicproject.memberservice.mapper.StudentMapper;
import com.academicproject.memberservice.repository.StudentRepository;
import com.academicproject.memberservice.repository.StudentSpecification;
import com.academicproject.memberservice.service.StudentService;
import com.academicproject.memberservice.util.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Override
    public StudentDTO createStudent(CreateStudentRequest request) {
        Student student = StudentMapper.INSTANCE.createRequestToEntity(request);
        student.setStudentId(CommonHelper.generateId("ST"));
        student.setStatus(StudentStatus.PENDING.name());

        studentRepository.save(student);
        paymentServiceClient.pay(buildPaymentRequest(student.getStudentId()));
        return StudentMapper.INSTANCE.toDTO(student);
    }

    @Override
    public Page<StudentDTO> getStudents(String studentId, String fullName, String gender, Pageable pageable) {
        Specification<Student> spec = StudentSpecification.filterBy(studentId, fullName, gender);
        Page<Student> studentPage = studentRepository.findAll(spec, pageable);
        return studentPage.map(StudentMapper.INSTANCE::toDTO);
    }

    @Override
    public StudentDTO getStudentDetail(String studentId) {
        return StudentMapper.INSTANCE.toDTO(studentRepository.findStudentByStudentId(studentId));
    }

    private PaymentRequest buildPaymentRequest(String studentId) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setStudentId(studentId);
        paymentRequest.setType(StudentPaymentType.MONTHLY.name());
        paymentRequest.setPaymentMethod(PaymentMethod.BANK_TRANSFER.name());
        paymentRequest.setYear(String.valueOf(LocalDate.now().getYear()));
        paymentRequest.setMonth(String.valueOf(LocalDate.now().getMonthValue()));

        //amount for first month only
        paymentRequest.setAmount(new BigDecimal(1000000));

        return paymentRequest;
    }
}
