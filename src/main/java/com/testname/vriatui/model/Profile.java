package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Profile {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer yearOfBirth;
    private Gender gender;
    private String diseases;
    private Set<String> phonesToNotify;
    private Address address;
    private String rhesusFactor;

    enum Gender {
        MALE, FEEMALE
    }
}
