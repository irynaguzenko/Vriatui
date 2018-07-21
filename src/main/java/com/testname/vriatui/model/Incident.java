package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;

@Data
public class Incident {
    @Id
    String id;
    GeoJsonPoint location;
    Address happenInAddress;
    String problem;
    LocalDateTime happenAt;
}
