package com.testname.vriatui.configuration;

import com.testname.vriatui.repository.IncidentRepository;
import com.testname.vriatui.repository.ProfileRepository;
import com.testname.vriatui.service.IncidentService;
import com.testname.vriatui.service.LocationResolver;
import com.testname.vriatui.service.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(value = "com.testname.vriatui.repository")
public class ServiceConfiguration {
    private final IncidentRepository incidentRepository;
    private final ProfileRepository profileRepository;

    public ServiceConfiguration(IncidentRepository incidentRepository,
                                ProfileRepository profileRepository) {
        this.incidentRepository = incidentRepository;
        this.profileRepository = profileRepository;
    }

    @Bean
    public LocationResolver locationResolver() {
        return new LocationResolver();
    }

    @Bean
    public IncidentService incidentService(ProfileService profileService) {
        return new IncidentService(incidentRepository, profileService);
    }

    @Bean
    public ProfileService profileService(LocationResolver locationResolver) {
        return new ProfileService(profileRepository, locationResolver);
    }
}
