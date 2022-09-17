package com.gfg;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Shashi",27,"Java");
        Student student1 = new Student();
        List<Student> list = new ArrayList<>();
        list.add(student1);
        Batch jbdl38 = new Batch(teacher,list);
    }
}
