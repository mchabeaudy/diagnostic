package com.awesome.medical.diagnostic.patient.service;

import com.awesome.medical.diagnostic.patient.controller.Patient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Patient service for basic operations
 */
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Get all patients
     *
     * @return all patients
     */
    public Collection<Patient> getAll() {
        List<PatientEntity> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients.stream().map(PatientMapper.INSTANCE::toModel).toList();
    }

    public Collection<Patient> getAllByIds(Collection<Integer> ids) {
        List<PatientEntity> patients = new ArrayList<>();
        patientRepository.findAllById(ids).forEach(patients::add);
        return patients.stream().map(PatientMapper.INSTANCE::toModel).toList();
    }

    /**
     * Add a patient
     *
     * @param patient patient to add
     * @return added patient
     */
    public Patient addPatient(Patient patient) {
        var patientToSave = new PatientEntity(0, patient.name(), patient.medicalIndex());
        var saved = patientRepository.save(patientToSave);
        return PatientMapper.INSTANCE.toModel(saved);
    }

    /**
     * Get a patient by id or null if not found
     *
     * @param id id of the patient
     * @return patient
     */
    public Patient getById(int id) {
        return patientRepository.findById(id).map(PatientMapper.INSTANCE::toModel).orElse(null);
    }

}
