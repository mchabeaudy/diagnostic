package com.awesome.medical.diagnostic.patient.service;

import org.springframework.data.annotation.Id;

/**
 * Patient entity
 *
 * @param id           id of the patient
 * @param medicalIndex medical index of the patient
 */
public record PatientEntity(@Id int id, String name, int medicalIndex) {

}
