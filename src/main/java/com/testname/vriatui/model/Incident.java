package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Incident {
    @Id
    private String id;
    private Address address;
    private String problem;
    private LocalDateTime happenAt;
    private PatientInfo patient;

    public Incident() {
    }

    public Incident(IncidentRequest incidentRequest, Profile profile) {
        this.address = incidentRequest.isHappenAtHome()
                ? profile.getAddress()
                : new Address(incidentRequest.getLocation());
        this.happenAt = LocalDateTime.now();
        this.problem = incidentRequest.getProblem();
        this.patient = new PatientInfo(profile);
    }
}
