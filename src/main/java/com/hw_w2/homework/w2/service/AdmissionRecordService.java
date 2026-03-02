package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.admission_record.*;

import java.util.List;

public interface AdmissionRecordService {

    AdmissionRecordResponse create(AdmissionRecordRequest request);

    List<AdmissionRecordResponse> getAll();

    AdmissionRecordResponse getById(Long id);

    AdmissionRecordResponse update(Long id, AdmissionRecordUpdateRequest request);

    AdmissionRecordResponse delete(Long id);
}