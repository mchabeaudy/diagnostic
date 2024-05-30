package com.awesome.medical.diagnostic.medicalunit.service;

import com.awesome.medical.diagnostic.medicalunit.controller.MedicalUnit;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T01:00:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (SAP SE)"
)
public class MedicalUnitMapperImpl implements MedicalUnitMapper {

    @Override
    public MedicalUnit toModel(MedicalUnitEntity entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        int medicalIndex = 0;

        id = entity.id();
        name = entity.name();
        medicalIndex = entity.medicalIndex();

        MedicalUnit medicalUnit = new MedicalUnit( id, name, medicalIndex );

        return medicalUnit;
    }

    @Override
    public MedicalUnitEntity toEntity(MedicalUnit entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        int medicalIndex = 0;

        id = entity.id();
        name = entity.name();
        medicalIndex = entity.medicalIndex();

        MedicalUnitEntity medicalUnitEntity = new MedicalUnitEntity( id, name, medicalIndex );

        return medicalUnitEntity;
    }
}
