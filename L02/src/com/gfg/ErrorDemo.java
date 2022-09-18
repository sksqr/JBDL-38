package com.gfg;

public class ErrorDemo {

     public void recursiveMethod(){
        recursiveMethod();
    }

    public static void main(String[] args) {
        ErrorDemo errorDemo = new ErrorDemo();
        errorDemo.recursiveMethod();
    }
}
