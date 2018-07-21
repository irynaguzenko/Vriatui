package com.testname.vriatui.repository;

import com.testname.vriatui.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidentRepository extends MongoRepository<Incident, String> {
}
