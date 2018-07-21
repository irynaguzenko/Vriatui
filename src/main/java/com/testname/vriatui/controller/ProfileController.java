package com.testname.vriatui.controller;

import com.testname.vriatui.model.IdResponse;
import com.testname.vriatui.model.Profile;
import com.testname.vriatui.service.ProfileService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public IdResponse create(@RequestBody Profile profile) {
        return new IdResponse(profileService.create(profile).getId());
    }

    @GetMapping
    public Profile get(@RequestParam("id") String profileId) {
        return profileService.findOne(profileId);
    }
}
