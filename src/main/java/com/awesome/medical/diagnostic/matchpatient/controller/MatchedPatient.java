package com.awesome.medical.diagnostic.matchpatient.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 * Represents a patient that was matched to medical units.
 *
 * @param patientId           unique identifier of the patient
 * @param patientName         name of the patient
 * @param matchedMedicalUnits medical units that matched the patient
 */
public record MatchedPatient(@Schema(description = "Identifier of the patient", example = "1") int patientId,
                             @Schema(description = "Patient name", example = "Josh") String patientName,
                             @Schema(description = "Matched medical units") List<MatchedMedicalUnit> matchedMedicalUnits) {

}
