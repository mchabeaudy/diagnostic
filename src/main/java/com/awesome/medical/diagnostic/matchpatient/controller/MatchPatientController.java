package com.awesome.medical.diagnostic.matchpatient.controller;

import com.awesome.medical.diagnostic.matchpatient.service.MatchPatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnostic/v1/matchpatient")
public class MatchPatientController {

    private final MatchPatientService matchPatientService;

    public MatchPatientController(MatchPatientService matchPatientService) {
        this.matchPatientService = matchPatientService;
    }

    @Operation(summary = "Match patients with a medical units",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Patients to match",
                    required = true, content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MatchPatientRequest.class))
            )
    )
    @ApiResponse(responseCode = "200", description = "Patient matched successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MatchedPatient.class)))
    @PostMapping
    public ResponseEntity<MatchedPatient> matchPatient(@RequestBody MatchPatientRequest matchPatientRequest) {
        var matched = matchPatientService.matchPatient(matchPatientRequest.patientId());
        if (matched == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matched);
    }
}
