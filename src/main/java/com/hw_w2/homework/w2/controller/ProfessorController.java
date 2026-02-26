package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping("/api/professor")
    public ProfessorResponse createProfessor(@RequestBody ProfessorRequest request) {
        return professorService.createProfessor(request);
    }

    @GetMapping("/api/professor/all")
    public List<ProfessorResponse> getAllProfessors() {
        return professorService.getAllProfessor();
    }
}
