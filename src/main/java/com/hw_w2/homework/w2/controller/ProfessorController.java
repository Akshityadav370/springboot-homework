package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.dto.professor.ProfessorUpdateRequest;
import com.hw_w2.homework.w2.service.ProfessorService;
import com.hw_w2.homework.w2.util.ResponseUtil;
import com.hw_w2.homework.w2.advices.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<ProfessorResponse>> createProfessor(
            @RequestBody ProfessorRequest request) {

        ProfessorResponse response = professorService.createProfessor(request);
        return ResponseUtil.success(response, HttpStatus.CREATED);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProfessorResponse>>> getAllProfessors() {

        List<ProfessorResponse> responses = professorService.getAllProfessor();
        return ResponseUtil.success(responses);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfessorResponse>> getProfessorById(
            @PathVariable Long id) {

        ProfessorResponse response = professorService.getProfessorById(id);
        return ResponseUtil.success(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfessorResponse>> deleteProfessorById(
            @PathVariable Long id) {

        ProfessorResponse response = professorService.deleteProfessorById(id);
        return ResponseUtil.success(response);
    }

    // PATCH (Partial Update)
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfessorResponse>> updateProfessorById(
            @PathVariable Long id,
            @RequestBody ProfessorUpdateRequest request) {

        ProfessorResponse response = professorService.updateProfessorById(id, request);
        return ResponseUtil.success(response);
    }
}