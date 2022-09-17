package com.gfg;

public class ClassObjectDemo {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Vishal");
        p1.lastName="Gupta";



        Person p2 = new Person();
        p2.setName("Shashi");


        System.out.println(p1);
        System.out.println(p2);

        p1 = p2;

        System.out.println(p1.getName());



        System.out.println(p1);
        System.out.println(p2);

        System.out.println(Person.numOfObjects);
        Person p3 = new Person("RAvi",23);
        System.out.println(Person.numOfObjects);


    }
}
