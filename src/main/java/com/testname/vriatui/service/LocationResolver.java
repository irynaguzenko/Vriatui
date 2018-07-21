package com.testname.vriatui.service;

import com.testname.vriatui.model.Address;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class LocationResolver {

    public void enrich(Address address) {
        address.setLocation(new GeoJsonPoint(1, 2));
    }
}
