package com.awesome.medical.diagnostic.medicalunit.controller;

import com.awesome.medical.diagnostic.medicalunit.service.MedicalUnitService;
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
 * Medical units controller
 */
@RestController
@RequestMapping("/api/diagnostic/v1/medicalunits")
public class MedicalUnitController {

    private final MedicalUnitService medicalUnitService;

    public MedicalUnitController(MedicalUnitService medicalUnitService) {
        this.medicalUnitService = medicalUnitService;
    }

    @Operation(summary = "Get all medical units", description = "Get all medical units from the database")
    @ApiResponse(responseCode = "200", description = "Found the medical unit", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalUnit.class))
    })
    @GetMapping
    public Collection<MedicalUnit> medicalUnits() {
        return medicalUnitService.getAll();
    }

    @Operation(summary = "Get a medical unit by id", description = "Get a medical unit by id from the database")
    @ApiResponse(responseCode = "200", description = "Found the medical unit", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalUnit.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicalUnit> getMedicalUnit(@PathVariable int id) {
        var medicalUnit = medicalUnitService.getById(id);
        if (medicalUnit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medicalUnit);
    }

    @Operation(summary = "Add a medical unit", description = "Add a medical unit to the database")
    @ApiResponse(responseCode = "201", description = "Medical unit added", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalUnit.class))
    })
    @PostMapping
    public ResponseEntity<MedicalUnit> addMedicalUnit(@RequestBody MedicalUnit medicalUnit) {
        var savedMedicalUnit = medicalUnitService.createMedicalUnit(medicalUnit);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMedicalUnit.id())
                .toUri();
        return ResponseEntity.created(location).body(savedMedicalUnit);
    }
}
