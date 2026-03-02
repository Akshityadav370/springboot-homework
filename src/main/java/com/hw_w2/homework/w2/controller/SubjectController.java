package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.advices.ApiResponse;
import com.hw_w2.homework.w2.dto.subject.*;
import com.hw_w2.homework.w2.service.SubjectService;
import com.hw_w2.homework.w2.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> create(
            @RequestBody SubjectRequest request) {

        return ResponseUtil.success(
                subjectService.create(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> getAll() {
        return ResponseUtil.success(subjectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> getById(
            @PathVariable Long id) {

        return ResponseUtil.success(subjectService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> update(
            @PathVariable Long id,
            @RequestBody SubjectUpdateRequest request) {

        return ResponseUtil.success(
                subjectService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> delete(
            @PathVariable Long id) {

        return ResponseUtil.success(
                subjectService.delete(id)
        );
    }
}