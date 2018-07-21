package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
public class IncidentRequest {
    private GeoJsonPoint location;
    private boolean happenAtHome;
    private String problem;
    private String profileId;
}
