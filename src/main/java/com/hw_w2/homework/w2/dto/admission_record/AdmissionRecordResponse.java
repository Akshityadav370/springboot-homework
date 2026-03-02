package com.hw_w2.homework.w2.dto.admission_record;

import java.time.LocalDate;

public record AdmissionRecordResponse(
        Long id,
        LocalDate admissionDate,
        String status
) {}
