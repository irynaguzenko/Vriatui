package com.testname.vriatui.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    String city;
    //street + house + flat etc.
    String value;
    Integer entrance;
    Integer floor;
    String comment;
    GeoJsonPoint location;

    public Address() {
    }

    Address(GeoJsonPoint location) {
        this.location = location;
    }
}
