package com.testname.vriatui.controller;

import com.testname.vriatui.dto.IncidentDto;
import com.testname.vriatui.model.Incident;
import com.testname.vriatui.service.IncidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incident")
public class IncidentController {
    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public Incident create(IncidentDto incidentDto) {
        return incidentService.create(incidentDto);
    }

    @GetMapping
    public Incident get(@RequestParam("id") String incidentId) {
        return incidentService.get(incidentId);
    }
}
