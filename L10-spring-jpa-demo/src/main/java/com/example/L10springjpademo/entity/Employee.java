package com.example.L10springjpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "salary", nullable = false)
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JsonIgnoreProperties("employees")
    private Branch branch;

}
