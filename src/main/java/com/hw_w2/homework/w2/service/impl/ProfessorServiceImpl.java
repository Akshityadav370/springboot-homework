package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.entity.Professor;
import com.hw_w2.homework.w2.mapper.ProfessorMapper;
import com.hw_w2.homework.w2.repository.ProfessorRepository;
import com.hw_w2.homework.w2.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Override
    public ProfessorResponse createProfessor(ProfessorRequest professorRequest) {
        Professor professor = new Professor();
        professor.setTitle(professorRequest.title());

        Professor savedProfessor = professorRepository.save(professor);
        return professorMapper.toResponse(savedProfessor);
    }

    @Override
    public List<ProfessorResponse> getAllProfessor() {
        List<Professor> allProfessor = professorRepository.findAll();
        return professorMapper.convertProfessorToListProfessorResponse(allProfessor);
    }
}
