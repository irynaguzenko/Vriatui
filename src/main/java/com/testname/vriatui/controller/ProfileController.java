package com.testname.vriatui.controller;

import com.testname.vriatui.dto.ProfileDto;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.service.ProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public Profile create(ProfileDto profileDto) {
        return profileService.create(profileDto);
    }
}
