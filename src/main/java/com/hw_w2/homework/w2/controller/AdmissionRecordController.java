package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.advices.ApiResponse;
import com.hw_w2.homework.w2.dto.admission_record.*;
import com.hw_w2.homework.w2.service.AdmissionRecordService;
import com.hw_w2.homework.w2.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admission-record")
public class AdmissionRecordController {

    private final AdmissionRecordService service;

    @PostMapping
    public ResponseEntity<ApiResponse<AdmissionRecordResponse>> create(
            @RequestBody AdmissionRecordRequest request) {

        return ResponseUtil.success(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AdmissionRecordResponse>>> getAll() {

        return ResponseUtil.success(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AdmissionRecordResponse>> getById(
            @PathVariable Long id) {

        return ResponseUtil.success(service.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<AdmissionRecordResponse>> update(
            @PathVariable Long id,
            @RequestBody AdmissionRecordUpdateRequest request) {

        return ResponseUtil.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<AdmissionRecordResponse>> delete(
            @PathVariable Long id) {

        return ResponseUtil.success(service.delete(id));
    }
}