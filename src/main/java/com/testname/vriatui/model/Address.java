package com.testname.vriatui.model;

import org.springframework.data.annotation.Id;

public class Address {
    @Id
    String id;
    String city;
    String value;
    String comment;
    Integer entrance;
    Integer floor;
}
