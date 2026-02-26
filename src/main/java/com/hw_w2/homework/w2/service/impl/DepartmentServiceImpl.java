package com.hw_w2.homework.w2.service.impl;

import com.hw_w2.homework.w2.dto.DepartmentRequest;
import com.hw_w2.homework.w2.dto.DepartmentResponse;
import com.hw_w2.homework.w2.dto.UpdateDepartmentRequest;
import com.hw_w2.homework.w2.entity.Department;
import com.hw_w2.homework.w2.repository.DepartmentRepository;
import com.hw_w2.homework.w2.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        return departmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        Department department = new Department();
        department.setTitle(request.title());
        department.setIsActive(request.isActive());

        Department saved = departmentRepository.save(department);

        return mapToResponse(saved);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, UpdateDepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setTitle(request.title());
        department.setIsActive(request.isActive());

        return mapToResponse(departmentRepository.save(department));
    }

    private DepartmentResponse mapToResponse(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getTitle(),
                department.getIsActive(),
                department.getCreatedAt()
        );
    }
}