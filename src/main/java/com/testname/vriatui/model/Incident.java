package com.testname.vriatui.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;

public class Incident {
    @Id
    String id;
    GeoJsonPoint location;
    Address happendInAddress;
    String problem;
    LocalDateTime happendAt;
}
