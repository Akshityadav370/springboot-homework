package com.hw_w2.homework.w2.dto.admission_record;

import java.time.LocalDate;

public record AdmissionRecordRequest(
        LocalDate admissionDate,
        String status
) {
}
