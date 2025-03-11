package com.academicproject.memberservice.mapper;

import com.academicproject.memberservice.domain.entity.Student;
import com.academicproject.memberservice.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "studentId", ignore = true) // Ignore ID if auto-generated
    Student toEntity(StudentDTO dto);

    StudentDTO toDTO(Student student);
}
