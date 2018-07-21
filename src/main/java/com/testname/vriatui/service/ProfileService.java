package com.testname.vriatui.service;

import com.testname.vriatui.exception.ObjectNotFoundException;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.repository.ProfileRepository;

public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile findOne(String profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ObjectNotFoundException(profileId));
    }
}
