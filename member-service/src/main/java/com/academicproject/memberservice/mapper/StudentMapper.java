package com.academicproject.memberservice.mapper;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import com.academicproject.memberservice.dto.request.CreateStudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "studentId", ignore = true) // Ignore ID if auto-generated
    Student createRequestToEntity(CreateStudentRequest request);

    StudentDTO toDTO(Student student);
}
