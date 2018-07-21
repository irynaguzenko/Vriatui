package com.testname.vriatui.service;

import com.testname.vriatui.dto.ProfileDto;
import com.testname.vriatui.model.Profile;

public class ProfileService {

    public Profile create(ProfileDto profileDto) {
        return new Profile();
    }
}
