package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;

@Data
public class Profile {
    @Id
    String id;
    String firstName;
    String lastName;
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
