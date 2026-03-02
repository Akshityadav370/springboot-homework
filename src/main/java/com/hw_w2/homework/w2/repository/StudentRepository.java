package com.hw_w2.homework.w2.repository;

import com.hw_w2.homework.w2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}