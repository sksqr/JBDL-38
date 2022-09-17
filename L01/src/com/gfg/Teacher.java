package com.gfg;

import com.gfg.Person;

public class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);

        this.subject = subject;
    }

    public void teach(){
        System.out.println("Teaching "+subject);
        System.out.println(this.hashCode());
        System.out.println(super.hashCode());
    }

//    @Override
//    public String toString(String n) {
//        return "Teacher{" +
//                "subject='" + subject + '\'' +
//                '}';
//    }


}
