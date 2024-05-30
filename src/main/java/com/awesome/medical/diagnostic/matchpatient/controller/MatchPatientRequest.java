package com.awesome.medical.diagnostic.matchpatient.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a request to match patients with medical units.
 *
 * @param patientId patient ids to match with medical units
 */
public record MatchPatientRequest(
        @Schema(description = "Patient id to match with medical units") Integer patientId) {

}
