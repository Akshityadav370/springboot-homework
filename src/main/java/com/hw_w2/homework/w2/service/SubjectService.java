package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.subject.*;

import java.util.List;

public interface SubjectService {

    SubjectResponse create(SubjectRequest request);

    List<SubjectResponse> getAll();

    SubjectResponse getById(Long id);

    SubjectResponse update(Long id, SubjectUpdateRequest request);

    SubjectResponse delete(Long id);
}