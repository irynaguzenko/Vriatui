package com.testname.vriatui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {
    @Id
    String id;
    String city;
    //street + house + flat etc.
    String value;
    Integer entrance;
    Integer floor;
    String comment;
}
