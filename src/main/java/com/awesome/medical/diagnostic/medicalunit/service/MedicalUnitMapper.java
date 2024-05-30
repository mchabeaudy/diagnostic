package com.awesome.medical.diagnostic.medicalunit.service;

import com.awesome.medical.diagnostic.medicalunit.controller.MedicalUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Medical unit mapper
 */
@Mapper
public interface MedicalUnitMapper {

    MedicalUnitMapper INSTANCE = Mappers.getMapper(MedicalUnitMapper.class);

    MedicalUnit toModel(MedicalUnitEntity entity);

    MedicalUnitEntity toEntity(MedicalUnit entity);
}
