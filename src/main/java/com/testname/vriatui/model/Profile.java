package com.testname.vriatui.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;

public class Profile {
    @Id
    String id;
    String firstname;
    String lastname;
    LocalDate birthday;
    Gender gender;
    String diseases;
    Set<String> phonesToNotify;
    Address address;
    Set<Incident> incidents;

    enum Gender {
        MALE, FEEMALE
    }
}
