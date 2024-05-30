package com.awesome.medical.diagnostic.medicalunit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Medical unit repository
 */
@Repository
public interface MedicalUnitRepository extends CrudRepository<MedicalUnitEntity, Integer> {

}
