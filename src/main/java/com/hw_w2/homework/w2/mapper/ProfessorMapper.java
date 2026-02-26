package com.hw_w2.homework.w2.mapper;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.entity.Professor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    Professor toEntity(ProfessorRequest request);

    ProfessorResponse toResponse(Professor professor);

    List<ProfessorResponse> convertProfessorToListProfessorResponse(List<Professor> professors);
}
