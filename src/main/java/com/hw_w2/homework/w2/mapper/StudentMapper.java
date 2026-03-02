package com.hw_w2.homework.w2.mapper;

import com.hw_w2.homework.w2.dto.admission_record.AdmissionRecordUpdateRequest;
import com.hw_w2.homework.w2.dto.student.StudentRequest;
import com.hw_w2.homework.w2.dto.student.StudentResponse;
import com.hw_w2.homework.w2.dto.student.StudentUpdateRequest;
import com.hw_w2.homework.w2.entity.AdmissionRecord;
import com.hw_w2.homework.w2.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest request);

    StudentResponse toResponse(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(
            StudentUpdateRequest dto,
            @MappingTarget Student entity
    );
}
