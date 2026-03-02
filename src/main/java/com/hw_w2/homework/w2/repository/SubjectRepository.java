package com.hw_w2.homework.w2.repository;

import com.hw_w2.homework.w2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}