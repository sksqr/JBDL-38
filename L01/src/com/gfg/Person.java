package com.gfg;

public class Person {

    public static int numOfObjects=0;

    public static Object obj1 = new Object();

    private String id;
    public String lastName;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Person(String name, int age){
        this.name=name;
        this.age=age;
        numOfObjects++;
    }

    public Person(){
        numOfObjects++;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println(name+" is walking");
    }
}
