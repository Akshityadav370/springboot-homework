package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.student.StudentRequest;
import com.hw_w2.homework.w2.dto.student.StudentResponse;
import com.hw_w2.homework.w2.dto.student.StudentUpdateRequest;
import com.hw_w2.homework.w2.entity.AdmissionRecord;
import com.hw_w2.homework.w2.entity.Student;
import com.hw_w2.homework.w2.entity.Subject;
import com.hw_w2.homework.w2.exception.ResourceNotFoundException;
import com.hw_w2.homework.w2.mapper.StudentMapper;
import com.hw_w2.homework.w2.repository.StudentRepository;
import com.hw_w2.homework.w2.repository.SubjectRepository;
import com.hw_w2.homework.w2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final SubjectRepository subjectRepository;
    private final StudentMapper mapper;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<StudentResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StudentResponse getById(Long id) {
        Student entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id)
                );

        return mapper.toResponse(entity);
    }

    @Override
    public StudentResponse update(Long id, StudentUpdateRequest request) {
        Student entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id)
                );

        mapper.updateEntityFromDto(request, entity);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public StudentResponse delete(Long id) {
        Student entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id)
                );

        repository.delete(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public void addSubject(Long studentId, Long subjectId) {
        Student student = repository.findById(studentId).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        student.addSubject(subject);
        repository.save(student);
    }

    @Override
    public void removeSubject(Long studentId, Long subjectId) {
        Student student = repository.findById(studentId).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        student.removeSubject(subject);
        repository.save(student);
    }
}
