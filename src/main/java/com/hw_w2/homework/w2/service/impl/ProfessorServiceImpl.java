package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.dto.professor.ProfessorUpdateRequest;
import com.hw_w2.homework.w2.entity.Professor;
import com.hw_w2.homework.w2.entity.Student;
import com.hw_w2.homework.w2.exception.ResourceNotFoundException;
import com.hw_w2.homework.w2.mapper.ProfessorMapper;
import com.hw_w2.homework.w2.repository.ProfessorRepository;
import com.hw_w2.homework.w2.repository.StudentRepository;
import com.hw_w2.homework.w2.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
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

    @Override
    public ProfessorResponse getProfessorById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));

        return professorMapper.toResponse(professor);
    }

    @Override
    public ProfessorResponse deleteProfessorById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));
        professorRepository.deleteById(professor.getId());

        return professorMapper.toResponse(professor);
    }

    @Override
    public ProfessorResponse updateProfessorById(Long id, ProfessorUpdateRequest request) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Professor not found with id: " + id)
                );

        if (request.title() != null) {
            professor.setTitle(request.title());
        }

        Professor updated = professorRepository.save(professor);

        return professorMapper.toResponse(updated);
    }

    @Override
    public void addStudent(Long professorId, Long studentId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        professor.addStudent(student);
        professorRepository.save(professor);
    }

    @Override
    public void removeStudent(Long professorId, Long studentId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        professor.removeStudent(student);
        professorRepository.save(professor);
    }
}
