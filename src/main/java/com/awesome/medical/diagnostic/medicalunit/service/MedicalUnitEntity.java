package com.awesome.medical.diagnostic.medicalunit.service;

import org.springframework.data.annotation.Id;

/**
 * Medical unit entity
 *
 * @param id           id of the medical unit
 * @param name         name of the medical unit
 * @param medicalIndex medical index of the medical unit
 */
public record MedicalUnitEntity(@Id int id, String name, int medicalIndex) {

}
