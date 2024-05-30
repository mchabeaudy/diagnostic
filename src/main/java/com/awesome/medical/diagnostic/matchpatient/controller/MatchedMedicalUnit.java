package com.awesome.medical.diagnostic.matchpatient.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a medical unit that matched a patient.
 *
 * @param id   unique identifier of the medical unit
 * @param name name of the medical unit
 */
public record MatchedMedicalUnit(@Schema(description = "Medical unit identifier", example = "1") int id,
                                 @Schema(description = "Medical unit name", example = "Cardiology") String name) {

}
