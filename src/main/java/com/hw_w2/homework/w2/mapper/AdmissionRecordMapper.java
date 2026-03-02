package com.hw_w2.homework.w2.mapper;

import com.hw_w2.homework.w2.dto.admission_record.*;
import com.hw_w2.homework.w2.entity.AdmissionRecord;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AdmissionRecordMapper {

    AdmissionRecordResponse toResponse(AdmissionRecord entity);

    AdmissionRecord toEntity(AdmissionRecordRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(
            AdmissionRecordUpdateRequest dto,
            @MappingTarget AdmissionRecord entity
    );
}