package com.shashi;

import com.gfg.AdultPerson;

public class DefaultDemo {

    public static void main(String[] args) {
        AdultPerson adultPerson = new AdultPerson();
        adultPerson.setName("Ravi");
        System.out.println(adultPerson.getName());

//        System.out.println(adultPerson.de);
//        System.out.println(adultPerson.pro);

        ProtectedDemo protectedDemo = new ProtectedDemo();

        System.out.println(protectedDemo.protectedMethod());
    }
}
