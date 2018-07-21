package com.testname.vriatui.service;

import com.testname.vriatui.exception.ObjectNotFoundException;
import com.testname.vriatui.model.Incident;
import com.testname.vriatui.model.IncidentInfo;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.repository.IncidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

public class IncidentService {
    private final IncidentRepository incidentRepository;
    private final ProfileService profileService;

    public IncidentService(IncidentRepository incidentRepository, ProfileService profileService) {
        this.incidentRepository = incidentRepository;
        this.profileService = profileService;
    }

    public Incident create(Incident incident) {
        incident.setHappenAt(LocalDateTime.now());
        if (incident.getHappenAtHome()) {
            Profile profile = profileService.findOne(incident.getProfileId());
            incident.setHappenInAddress(profile.getAddress());
        }
        return incidentRepository.save(incident);
    }

    public IncidentInfo findOne(String incidentId) {
        return incidentRepository.findById(incidentId)
                .map(incident -> new IncidentInfo(incident, profileService.findOne(incident.getProfileId())))
                .orElseThrow(() -> new ObjectNotFoundException(incidentId));
    }

    public Page<IncidentInfo> findPaginated(int page, int size) {
        return incidentRepository.findAll(PageRequest.of(page, size))
                .map(incident -> new IncidentInfo(incident, profileService.findOne(incident.getProfileId())));
    }
}
