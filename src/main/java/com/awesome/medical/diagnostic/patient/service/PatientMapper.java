package com.awesome.medical.diagnostic.patient.service;

import com.awesome.medical.diagnostic.medicalunit.service.MedicalUnitMapper;
import com.awesome.medical.diagnostic.patient.controller.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientEntity toEntity(Patient dto);

    Patient toModel(PatientEntity entity);
}
