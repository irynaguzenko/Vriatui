package com.testname.vriatui.configuration;

import com.testname.vriatui.service.IncidentService;
import com.testname.vriatui.service.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public IncidentService incidentService() {
        return new IncidentService();
    }

    @Bean
    public ProfileService profileService() {
        return new ProfileService();
    }
}
