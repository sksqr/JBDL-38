package com.example.L10springjpademo.entity;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Address {

    private Integer id;

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String pincode;

}








