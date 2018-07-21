package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;

@Data
public class Incident {
    @Id
    private String id;
    private GeoJsonPoint location;
    private Address happenInAddress;
    private boolean happenAtHome;
    private String problem;
    private LocalDateTime happenAt;
    private String profileId;
}
