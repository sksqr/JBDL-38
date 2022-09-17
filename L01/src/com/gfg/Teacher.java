package com;

import com.gfg.Person;

public class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void teach(){
        System.out.println("Teaching "+subject);
    }
}
