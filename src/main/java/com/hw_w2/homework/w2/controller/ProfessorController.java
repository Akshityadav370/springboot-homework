package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.dto.professor.ProfessorRequest;
import com.hw_w2.homework.w2.dto.professor.ProfessorResponse;
import com.hw_w2.homework.w2.dto.professor.ProfessorUpdateRequest;
import com.hw_w2.homework.w2.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    // GET professor by id
    // GET all professor
    // POST create professor
    // DELETE professor
    // UPDATE professor

    @PostMapping("/api/professor")
    public ProfessorResponse createProfessor(@RequestBody ProfessorRequest request) {
        return professorService.createProfessor(request);
    }

    @GetMapping("/api/professor/all")
    public List<ProfessorResponse> getAllProfessors() {
        return professorService.getAllProfessor();
    }

    @GetMapping("/api/professor/{id}")
    public ProfessorResponse getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @DeleteMapping("/api/professor/{id}")
    public ProfessorResponse deleteProfessorById(@PathVariable Long id) {
        return professorService.deleteProfessorById(id);
    }

    @PatchMapping("/api/professor/{id}")
    public ProfessorResponse updateProfessorById(@PathVariable Long id, @RequestBody ProfessorUpdateRequest request) {
        return professorService.updateProfessorById(id, request);
    }
}
