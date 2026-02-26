package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.dto.DepartmentResponse;
import com.hw_w2.homework.w2.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/api/department/all")
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartment();
    }
}
