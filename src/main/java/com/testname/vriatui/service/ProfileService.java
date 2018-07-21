package com.testname.vriatui.service;

import com.testname.vriatui.exception.ObjectNotFoundException;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.repository.ProfileRepository;

public class ProfileService {
    private final ProfileRepository profileRepository;
    private final LocationResolver locationEnricher;

    public ProfileService(ProfileRepository profileRepository, LocationResolver locationEnricher) {
        this.profileRepository = profileRepository;
        this.locationEnricher = locationEnricher;
    }

    public Profile create(Profile profile) {
        locationEnricher.enrich(profile.getAddress());
        return profileRepository.save(profile);
    }

    public Profile findOne(String profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ObjectNotFoundException(profileId));
    }

    public void delete(String id) {
        profileRepository.deleteById(id);
    }

    public void cleanUp() {
        profileRepository.deleteAll();
    }
}
