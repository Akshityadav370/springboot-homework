package com.hw_w2.homework.w2.repository;

import com.hw_w2.homework.w2.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}