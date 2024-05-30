package com.awesome.medical.diagnostic.matchpatient.service;

import com.awesome.medical.diagnostic.matchpatient.controller.MatchedMedicalUnit;
import com.awesome.medical.diagnostic.matchpatient.controller.MatchedPatient;
import com.awesome.medical.diagnostic.medicalunit.controller.MedicalUnit;
import com.awesome.medical.diagnostic.medicalunit.service.MedicalUnitService;
import com.awesome.medical.diagnostic.patient.controller.Patient;
import com.awesome.medical.diagnostic.patient.service.PatientService;
import org.springframework.stereotype.Service;

/**
 * Service to match patients with medical units
 */
@Service
public class MatchPatientService {

    private final PatientService patientService;
    private final MedicalUnitService medicalUnitService;

    public MatchPatientService(PatientService patientService, MedicalUnitService medicalUnitService) {
        this.patientService = patientService;
        this.medicalUnitService = medicalUnitService;
    }

    /**
     * Match a patient with medical units
     *
     * @param patientId patient id to match
     * @return matched patient or null if not found
     */
    public MatchedPatient matchPatient(int patientId) {
        var medicalUnits = medicalUnitService.getAll();
        var patient = patientService.getById(patientId);
        if (patient == null) {
            return null;
        }
        var matchedMedicalUnits = medicalUnits.stream()
                .filter(medicalUnit -> matchWithPatient(patient, medicalUnit))
                .map(medicalUnit -> new MatchedMedicalUnit(medicalUnit.id(), medicalUnit.name()))
                .toList();
        return new MatchedPatient(patient.id(), patient.name(), matchedMedicalUnits);
    }

    private boolean matchWithPatient(Patient patient, MedicalUnit medicalUnit) {
        return patient.medicalIndex() % medicalUnit.medicalIndex() == 0;
    }
}
