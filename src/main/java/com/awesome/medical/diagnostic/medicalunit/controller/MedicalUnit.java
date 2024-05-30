package com.awesome.medical.diagnostic.medicalunit.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Medical unit that provides medical services
 *
 * @param id           unique identifier of the medical unit
 * @param name         name of the medical unit
 * @param medicalIndex medical index of the medical unit
 */
@Schema(description = "Medical unit that provides medical services")
public record MedicalUnit(@Schema(description = "Unique identifier of the medical unit", example = "1") int id,
                          @Schema(description = "Name of the medical unit", example = "cardiology") String name,
                          @Schema(description = "Medical index of the medical unit") int medicalIndex) {

}
