package com.awesome.medical.diagnostic.matchpatient.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.awesome.medical.diagnostic.matchpatient.service.MatchPatientService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(MatchPatientController.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class MatchPatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchPatientService matchPatientService;

    @Test
    void givenValidPatientId_whenMatchPatient_thenReturnsMatchedPatient() throws Exception {
        // given
        var patientId = 1;
        var matchedPatient = new MatchedPatient(patientId, "John Doe", List.of(new MatchedMedicalUnit(1, "Unit 1")));
        when(matchPatientService.matchPatient(patientId)).thenReturn(matchedPatient);

        // when
        var response = mockMvc.perform(MockMvcRequestBuilders.post("/api/diagnostic/v1/matchpatient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"patientId\": 1}"))
                .andExpect(status().isOk())
                .andReturn();

        // then
        var responseBody = response.getResponse().getContentAsString();
        assertThat(responseBody).isEqualTo("""
                {"patientId":1,"patientName":"John Doe","matchedMedicalUnits":[{"id":1,"name":"Unit 1"}]}""");
    }

    @Test
    void givenInvalidPatientId_whenMatchPatient_thenReturnsNotFound() throws Exception {
        // given
        var patientId = 1;
        when(matchPatientService.matchPatient(patientId)).thenReturn(null);

        // when
        var response = mockMvc.perform(MockMvcRequestBuilders.post("/api/diagnostic/v1/matchpatient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"patientId\": 1}"))
                .andExpect(status().isNotFound())
                .andReturn();

        // then
        var responseBody = response.getResponse().getContentAsString();
        assertThat(responseBody).isEmpty();
    }

}