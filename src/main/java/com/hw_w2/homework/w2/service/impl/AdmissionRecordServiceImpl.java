package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.admission_record.*;
import com.hw_w2.homework.w2.entity.AdmissionRecord;
import com.hw_w2.homework.w2.exception.ResourceNotFoundException;
import com.hw_w2.homework.w2.mapper.AdmissionRecordMapper;
import com.hw_w2.homework.w2.repository.AdmissionRecordRepository;
import com.hw_w2.homework.w2.service.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmissionRecordServiceImpl implements AdmissionRecordService {

    private final AdmissionRecordRepository repository;
    private final AdmissionRecordMapper mapper;

    @Override
    public AdmissionRecordResponse create(AdmissionRecordRequest request) {
        AdmissionRecord entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<AdmissionRecordResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public AdmissionRecordResponse getById(Long id) {
        AdmissionRecord entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("AdmissionRecord not found with id: " + id)
                );

        return mapper.toResponse(entity);
    }

    @Override
    public AdmissionRecordResponse update(Long id, AdmissionRecordUpdateRequest request) {

        AdmissionRecord entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("AdmissionRecord not found with id: " + id)
                );

        mapper.updateEntityFromDto(request, entity);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public AdmissionRecordResponse delete(Long id) {

        AdmissionRecord entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("AdmissionRecord not found with id: " + id)
                );

        repository.delete(entity);

        return mapper.toResponse(entity);
    }
}