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
        this.id = incident.id;
        this.location = incident.location;
        this.problem = incident.problem;
        this.happenAt = incident.happenAt;
        this.patientInfo = new PatientInfo(profile);
        this.address = incident.happenInAddress;
    }
}
