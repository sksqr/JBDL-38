package com.gfg;

public class EncapsulationDemo {

    public static void main(String[] args) {
        AdultPerson p1 = new AdultPerson();
        p1.setName("Shashi");
        p1.setAge(26);

        System.out.println(p1 instanceof AdultPerson);

        System.out.println(p1);
        System.out.println(p1.defaultMethod());

        System.out.println(p1.protectedMethod());

    }
}
