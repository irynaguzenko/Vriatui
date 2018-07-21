package com.testname.vriatui.configuration;

import com.fasterxml.jackson.databind.Module;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.geo.GeoJsonModule;

@Configuration
@EnableConfigurationProperties({MongoProperties.class})
public class MongoDbConfiguration {

    @Bean
    public MongoClient mongoClient(MongoProperties mongoProperties) {
        return new MongoClient(new MongoClientURI(mongoProperties.getUri()));
    }

    @Bean
    public Module registerGeoJsonModule() {
        return new GeoJsonModule();
    }
}
