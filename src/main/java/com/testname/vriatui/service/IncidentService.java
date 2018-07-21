package com.testname.vriatui.service;

import com.testname.vriatui.model.Incident;
import org.springframework.data.domain.Page;

public class IncidentService {

    public Incident create(Incident incident) {
        return incident;
    }

    public Incident findOne(String incidentId) {
        Incident incident = new Incident();
        incident.setId(incidentId);
        return incident;
    }

    public Page<Incident> findPaginated(int page, int size) {
        return null;
    }
}
