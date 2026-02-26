package com.hw_w2.homework.w2.dto;

import java.time.Instant;

public record DepartmentResponse(
        Long id,
        String title,
        Boolean isActive,
        Instant createdAt
) { }
