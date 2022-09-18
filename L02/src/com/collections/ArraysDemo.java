package com.collections;

import java.util.ArrayList;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {

        String[] students = new String[2];

        students[0]="Ravi";
        students[1]="Rohan";

        String[] temp = new String[10];
        for(int i=0; i<students.length; i++){
            temp[i] = students[i];
        }
        students = temp;
        students[2] = "Ravi";


        List<String> list = new ArrayList<>();
        list.add("ravi");
        list.add("rohan");
        list.add("vishnu");






    }
}
