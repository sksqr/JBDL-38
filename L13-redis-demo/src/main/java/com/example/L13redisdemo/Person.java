package com.example.L13redisdemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private Long id;

    private String name;

    private String phone;

}
