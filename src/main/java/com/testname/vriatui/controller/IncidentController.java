package com.testname.vriatui.controller;

import com.testname.vriatui.model.IdResponse;
import com.testname.vriatui.model.Incident;
import com.testname.vriatui.model.IncidentInfo;
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
    public IdResponse create(@RequestBody Incident incident) {
        return new IdResponse(incidentService.create(incident).getId());
    }

    @GetMapping(params = {"id"})
    public IncidentInfo get(@RequestParam("id") String incidentId) {
        return incidentService.findOne(incidentId);
    }

    @GetMapping
    public Page<IncidentInfo> getAllIncidents(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                              @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return incidentService.findPaginated(page, size);
    }
}
