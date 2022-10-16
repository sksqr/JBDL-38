package com.example.L10springjpademo.entity;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Employee {

    private Integer id;

    private String name;

    private Double salary;

    private Address address;

    private Branch branch;

}
