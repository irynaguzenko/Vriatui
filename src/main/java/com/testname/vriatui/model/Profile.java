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
    Integer yearOfBirth;
    Gender gender;
    String diseases;
    Set<String> phonesToNotify;
    Address address;

    enum Gender {
        MALE, FEEMALE
    }
}
