package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.dto.professor.ProfessorUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    ProfessorResponse createProfessor(ProfessorRequest professorRequest);

    List<ProfessorResponse> getAllProfessor();

    ProfessorResponse getProfessorById(Long id);

    ProfessorResponse deleteProfessorById(Long id);

    ProfessorResponse updateProfessorById(Long id, ProfessorUpdateRequest professorRequest);
}
