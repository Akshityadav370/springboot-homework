package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    ProfessorResponse createProfessor(ProfessorRequest professorRequest);

    List<ProfessorResponse> getAllProfessor();
}
