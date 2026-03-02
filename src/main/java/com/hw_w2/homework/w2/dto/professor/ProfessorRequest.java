package com.hw_w2.homework.w2.dto.professor;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequest(@NotBlank String title) {
}
