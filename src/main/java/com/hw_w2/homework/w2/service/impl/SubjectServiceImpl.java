package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.subject.*;
import com.hw_w2.homework.w2.entity.Professor;
import com.hw_w2.homework.w2.entity.Subject;
import com.hw_w2.homework.w2.exception.ResourceNotFoundException;
import com.hw_w2.homework.w2.repository.ProfessorRepository;
import com.hw_w2.homework.w2.repository.SubjectRepository;
import com.hw_w2.homework.w2.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    @Override
    public SubjectResponse create(SubjectRequest request) {

        Professor professor = professorRepository.findById(request.professorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Professor not found with id: " + request.professorId()
                        )
                );

        Subject subject = new Subject();
        subject.setTitle(request.title());
        subject.setProfessor(professor);

        return mapToResponse(subjectRepository.save(subject));
    }

    @Override
    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public SubjectResponse getById(Long id) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subject not found with id: " + id
                        )
                );

        return mapToResponse(subject);
    }

    @Override
    public SubjectResponse update(Long id, SubjectUpdateRequest request) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subject not found with id: " + id
                        )
                );

        if (request.title() != null) {
            subject.setTitle(request.title());
        }

        return mapToResponse(subjectRepository.save(subject));
    }

    @Override
    public SubjectResponse delete(Long id) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subject not found with id: " + id
                        )
                );

        subjectRepository.delete(subject);

        return mapToResponse(subject);
    }

    private SubjectResponse mapToResponse(Subject subject) {
        return new SubjectResponse(
                subject.getId(),
                subject.getTitle(),
                subject.getProfessor().getId()
        );
    }
}