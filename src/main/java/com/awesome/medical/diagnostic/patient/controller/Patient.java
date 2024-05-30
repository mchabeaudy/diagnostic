package com.awesome.medical.diagnostic.patient.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Details about a patient
 *
 * @param id                  unique identifier of the patient
 * @param patientMedicalIndex patient {@link PatientMedicalIndex}
 */
@Schema(description = "Details about a patient")
public record Patient(@Schema(description = "Unique identifier of the patient", example = "1") int id,
                      @Schema(description = "Name of the patient" , example = "Josh") String name,
                      @Schema(description = "Medical index represents the condition of the patient") int medicalIndex) {

}
