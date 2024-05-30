package com.awesome.medical.diagnostic.patient.controller;

import com.awesome.medical.diagnostic.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Patients controller
 */
@RestController
@RequestMapping("/api/diagnostic/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Operation(summary = "Get all patients", description = "Get all patients from the database")
    @ApiResponse(responseCode = "200", description = "Found the patient", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class))
    })
    @GetMapping
    public Collection<Patient> patients() {
        return patientService.getAll();
    }

    @Operation(summary = "Get a patient by id", description = "Get a patient by id from the database")
    @ApiResponse(responseCode = "200", description = "Found the patient", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id) {
        var patient = patientService.getById(id);
        if(patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @Operation(summary = "Add a patient", description = "Add a patient to the database")
    @ApiResponse(responseCode = "200", description = "Patient added", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class))
    })
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.id())
                .toUri();
        var patientAdded = patientService.addPatient(patient);
        return ResponseEntity.created(location).body(patientAdded);
    }


}
