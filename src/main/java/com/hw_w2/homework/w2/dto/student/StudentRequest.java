package com.hw_w2.homework.w2.dto.student;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
        @NotBlank String name
) {
}
