package com.shashi;

import com.gfg.AdultPerson;

public class ProtectedDemo extends AdultPerson {

    public static void main(String[] args) {
        ProtectedDemo protectedDemo = new ProtectedDemo();
        System.out.println(protectedDemo.protectedMethod());

    }

    @Override
    protected String protectedMethod() {

        return "overriden "+super.protectedMethod();
    }
}
