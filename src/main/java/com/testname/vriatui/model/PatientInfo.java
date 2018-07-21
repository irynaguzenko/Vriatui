package com.testname.vriatui.model;

import lombok.Data;

@Data
public class PatientInfo {
    private String id;
    private String firstName;
    private String lastName;
    private Integer yearOfBirth;
    private Profile.Gender gender;
    private String diseases;
    private String rhesusFactor;

    public PatientInfo() {
    }

    public PatientInfo(Profile profile) {
        this.id = profile.getId();
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
        this.yearOfBirth = profile.getYearOfBirth();
        this.gender = profile.getGender();
        this.diseases = profile.getDiseases();
        this.rhesusFactor = profile.getRhesusFactor();
    }
}
