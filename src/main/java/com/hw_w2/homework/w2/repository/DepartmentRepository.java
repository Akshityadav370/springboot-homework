package com.hw_w2.homework.w2.repository;

import com.hw_w2.homework.w2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}