package com.testname.vriatui.model;

import lombok.Value;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;

@Value
public class IncidentInfo {
    private String id;
    private GeoJsonPoint location;
    private String problem;
    private LocalDateTime happenAt;
    private PatientInfo patientInfo;
    private Address address;

    public IncidentInfo(Incident incident, Profile profile) {
        this.id = incident.getId();
        this.location = incident.getLocation();
        this.problem = incident.getProblem();
        this.happenAt = incident.getHappenAt();
        this.patientInfo = new PatientInfo(profile);
        this.address = incident.getHappenInAddress();
    }
}
