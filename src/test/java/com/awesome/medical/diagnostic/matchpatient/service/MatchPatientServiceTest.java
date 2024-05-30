package com.awesome.medical.diagnostic.matchpatient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import com.awesome.medical.diagnostic.matchpatient.controller.MatchedMedicalUnit;
import com.awesome.medical.diagnostic.medicalunit.controller.MedicalUnit;
import com.awesome.medical.diagnostic.medicalunit.service.MedicalUnitService;
import com.awesome.medical.diagnostic.patient.controller.Patient;
import com.awesome.medical.diagnostic.patient.service.PatientService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MatchPatientServiceTest {


    @Mock
    private PatientService patientService;

    @Mock
    private MedicalUnitService medicalUnitService;

    @Test
    void givenValidPatientId_whenMatchPatient_thenReturnsMatchedPatient() {
        // given
        var matchPatientService = new MatchPatientService(patientService, medicalUnitService);
        doReturn(List.of(new MedicalUnit(1, "Unit 3", 3), new MedicalUnit(2, "Unit 4", 4),
                new MedicalUnit(3, "Unit 5", 5)))
                .when(medicalUnitService)
                .getAll();
        var patient = new Patient(1, "John Doe", 15);
        doReturn(patient)
                .when(patientService)
                .getById(1);

        // when
        var matched = matchPatientService.matchPatient(1);

        // then
        assertThat(matched.patientId()).isEqualTo(patient.id());
        assertThat(matched.patientName()).isEqualTo(patient.name());
        assertThat(matched.matchedMedicalUnits()).containsExactlyInAnyOrder(
                new MatchedMedicalUnit(1, "Unit 3"),
                new MatchedMedicalUnit(3, "Unit 5")
        );
    }

    @Test
    void givenInvalidPatientId_whenMatchPatient_thenReturnsNull() {
        // given
        var matchPatientService = new MatchPatientService(patientService, medicalUnitService);
        doReturn(null)
                .when(patientService)
                .getById(1);

        // when
        var matched = matchPatientService.matchPatient(1);

        // then
        assertThat(matched).isNull();
    }
}