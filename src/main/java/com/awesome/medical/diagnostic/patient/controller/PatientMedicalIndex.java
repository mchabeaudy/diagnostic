package com.awesome.medical.diagnostic.patient.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Medical index represents the condition of the patient
 *
 * @param value medical index value
 */
@Schema(description = "Medical index represents the condition of the patient")
public record PatientMedicalIndex(int value) {

}
