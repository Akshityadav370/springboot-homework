package com.hw_w2.homework.w2.service;

import com.hw_w2.homework.w2.dto.DepartmentRequest;
import com.hw_w2.homework.w2.dto.DepartmentResponse;
import com.hw_w2.homework.w2.dto.UpdateDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAllDepartment();
    DepartmentResponse createDepartment(DepartmentRequest department);
    DepartmentResponse updateDepartment(Long id, UpdateDepartmentRequest department);
}
