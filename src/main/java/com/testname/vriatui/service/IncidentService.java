package com.testname.vriatui.service;

import com.testname.vriatui.exception.ObjectNotFoundException;
import com.testname.vriatui.model.Incident;
import com.testname.vriatui.model.IncidentRequest;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.repository.IncidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class IncidentService {
    private final IncidentRepository incidentRepository;
    private final ProfileService profileService;

    public IncidentService(IncidentRepository incidentRepository, ProfileService profileService) {
        this.incidentRepository = incidentRepository;
        this.profileService = profileService;
    }

    public Incident create(IncidentRequest incidentRequest) {
        Profile profile = profileService.findOne(incidentRequest.getProfileId());
        return incidentRepository.save(new Incident(incidentRequest, profile));
    }

    public Incident findOne(String incidentId) {
        return incidentRepository.findById(incidentId)
                .orElseThrow(() -> new ObjectNotFoundException(incidentId));
    }

    public Page<Incident> findPaginated(int page, int size) {
        return incidentRepository.findAll(PageRequest.of(page, size));
    }

    public void cleanUp() {
        incidentRepository.deleteAll();
    }

    public void delete(String id) {
        incidentRepository.deleteById(id);
    }
}
