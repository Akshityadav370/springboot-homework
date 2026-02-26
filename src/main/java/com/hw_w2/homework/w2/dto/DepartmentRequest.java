package com.hw_w2.homework.w2.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartmentRequest(
        @NotBlank String title,
        Boolean isActive
) {
}
