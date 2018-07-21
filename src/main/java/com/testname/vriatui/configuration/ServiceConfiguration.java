package com.testname.vriatui.configuration;

import com.testname.vriatui.repository.IncidentRepository;
import com.testname.vriatui.repository.ProfileRepository;
import com.testname.vriatui.service.IncidentService;
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
    public IncidentService incidentService() {
        return new IncidentService(incidentRepository, profileRepository);
    }

    @Bean
    public ProfileService profileService() {
        return new ProfileService(profileRepository);
    }
}
