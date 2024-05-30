package com.awesome.medical.diagnostic.medicalunit.service;

import com.awesome.medical.diagnostic.medicalunit.controller.MedicalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Medical unit service
 */
@Service
public class MedicalUnitService {

    private final MedicalUnitRepository medicalUnitRepository;

    public MedicalUnitService(MedicalUnitRepository medicalUnitRepository) {
        this.medicalUnitRepository = medicalUnitRepository;
    }

    public MedicalUnit getById(int id) {
        return medicalUnitRepository.findById(id).map(MedicalUnitMapper.INSTANCE::toModel).orElse(null);
    }

    public MedicalUnit createMedicalUnit(MedicalUnit medicalUnit) {
        var medicalUnitToSave = new MedicalUnitEntity(0, medicalUnit.name(), medicalUnit.medicalIndex());
        return MedicalUnitMapper.INSTANCE.toModel(medicalUnitRepository.save(medicalUnitToSave));
    }

    public Collection<MedicalUnit> getAll() {
        var medicalUnits = medicalUnitRepository.findAll().spliterator();
        List<MedicalUnit> list = new ArrayList<>();
        medicalUnits.forEachRemaining(entity -> list.add(MedicalUnitMapper.INSTANCE.toModel(entity)));
        return list;
    }

}
