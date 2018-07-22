package com.testname.vriatui.controller;

import com.testname.vriatui.model.Incident;
import com.testname.vriatui.model.IncidentRequest;
import com.testname.vriatui.service.IncidentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/incident")
public class IncidentController {
    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public Incident create(@RequestBody IncidentRequest incident) {
        return incidentService.create(incident);
    }

    @GetMapping(params = {"id"})
    public Incident get(@RequestParam("id") String incidentId) {
        return incidentService.findOne(incidentId);
    }

    @GetMapping
    public Page<Incident> getAllIncidents(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return incidentService.findPaginated(page, size);
    }

    @DeleteMapping
    public void cleanUp() {
        incidentService.cleanUp();
    }

    @DeleteMapping(params = {"id"})
    public void deleteById(@RequestParam("id") String id) {
        incidentService.delete(id);
    }
}
