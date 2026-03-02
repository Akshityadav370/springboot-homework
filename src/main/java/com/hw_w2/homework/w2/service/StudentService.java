package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.student.StudentRequest;
import com.hw_w2.homework.w2.dto.student.StudentResponse;
import com.hw_w2.homework.w2.dto.student.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    StudentResponse create(StudentRequest request);

    List<StudentResponse> getAll();

    StudentResponse getById(Long id);

    StudentResponse update(Long id, StudentUpdateRequest request);

    StudentResponse delete(Long id);

    void addSubject(Long studentId, Long subjectId);

    void removeSubject(Long studentId, Long subjectId);
}
