package com.example.L10springjpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
public class Branch {

    private Integer id;

    private String name;

    private Set<Employee> employees;


}
