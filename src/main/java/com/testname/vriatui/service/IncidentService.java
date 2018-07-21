package com.testname.vriatui.service;

import com.testname.vriatui.exception.ObjectNotFoundException;
import com.testname.vriatui.model.Incident;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.repository.IncidentRepository;
import com.testname.vriatui.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

public class IncidentService {
    private final IncidentRepository incidentRepository;
    private final ProfileRepository profileRepository;

    public IncidentService(IncidentRepository incidentRepository, ProfileRepository profileRepository) {
        this.incidentRepository = incidentRepository;
        this.profileRepository = profileRepository;
    }

    public String create(Incident incident) {
        incident.setHappenAt(LocalDateTime.now());
        if (incident.getHappenAtHome()) {
            Profile profile = profileRepository.findById(incident.getProfileId())
                    .orElseThrow(ObjectNotFoundException::new);
            incident.setHappenInAddress(profile.getAddress());
        }
        return incidentRepository.save(incident).getId();
    }

    public Incident findOne(String incidentId) {
        return incidentRepository.findById(incidentId)
                .orElseThrow(() -> new ObjectNotFoundException(incidentId));
    }

    public Page<Incident> findPaginated(int page, int size) {
        return incidentRepository.findAll(PageRequest.of(page, size));
    }
}
