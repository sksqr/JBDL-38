package com.gfg;

public class InheritanceDemo {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Rohan", 30, "Java");
        teacher.walk();
        teacher.teach();

        System.out.println(teacher instanceof  Person);
        System.out.println(teacher instanceof Teacher);
        System.out.println(teacher instanceof Object);

        System.out.println(Person.numOfObjects);
    }


}
