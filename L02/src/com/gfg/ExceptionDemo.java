package com.gfg;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionDemo {

    public static void main(String[] args)  {
//        String name = null;
//        System.out.println(name.length());
//        System.out.println("End");
//        FileReader fileReader = new FileReader("/tmp/testfile");


//        Object[] array = new Object[2];
//        array[2]=new Object();


        ExceptionDemo exceptionDemo = new ExceptionDemo();
        try {
            exceptionDemo.readFromFile();
            exceptionDemo.getProduct("");
        } catch (FileNotFoundException | ProductNotFoundException e) {

        }


        try {
            exceptionDemo.readFromFile();
            exceptionDemo.getProduct("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Executing finally");
        }
        System.out.println("Executing  outside finally");

    }

    public String readFromFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("/tmp/testfile");
        return null;
    }


    public String getProduct(String name) throws ProductNotFoundException {
        int i=1;
        if(name.isEmpty()){
            throw new ProductNotFoundException();
        }
        return null;
    }

}

