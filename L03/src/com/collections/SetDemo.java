package com.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {


    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();

        Set<Person> sortedSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
//                return person.getAge()-person.getAge();
                return person.getName().compareTo(t1.getName());
            }
        });

        personSet.add(new Person("Ravi",30));

        personSet.add(new Person("Shashi",30));

        personSet.add(new Person("Ravi",30));

        System.out.println(personSet.size());
    }
}
