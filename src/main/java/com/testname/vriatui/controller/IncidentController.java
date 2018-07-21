package com.testname.vriatui.controller;

import com.testname.vriatui.model.Incident;
import com.testname.vriatui.service.IncidentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incident")
public class IncidentController {
    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public Incident create(Incident incident) {
        return incidentService.create(incident);
    }

    @GetMapping
    public Incident get(@RequestParam("id") String incidentId) {
        return incidentService.findOne(incidentId);
    }

    @GetMapping(params = {"page", "size"})
    public Page<Incident> getAllIncidents(@RequestParam("page") int page, @RequestParam("size") int size) {
        return incidentService.findPaginated(page, size);
    }
}
