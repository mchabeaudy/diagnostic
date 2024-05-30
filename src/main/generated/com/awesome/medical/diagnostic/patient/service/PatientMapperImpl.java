package com.awesome.medical.diagnostic.patient.service;

import com.awesome.medical.diagnostic.patient.controller.Patient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T01:00:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (SAP SE)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientEntity toEntity(Patient dto) {
        if ( dto == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        int medicalIndex = 0;

        id = dto.id();
        name = dto.name();
        medicalIndex = dto.medicalIndex();

        PatientEntity patientEntity = new PatientEntity( id, name, medicalIndex );

        return patientEntity;
    }

    @Override
    public Patient toModel(PatientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        int medicalIndex = 0;

        id = entity.id();
        name = entity.name();
        medicalIndex = entity.medicalIndex();

        Patient patient = new Patient( id, name, medicalIndex );

        return patient;
    }
}
