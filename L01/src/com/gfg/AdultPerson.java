package com.gfg;

public class AdultPerson {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18){
            System.out.println("Wrong Input");
            throw new RuntimeException("Age is invalid");
        }
        else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "AdultPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    String defaultMethod(){
        return "Executing default";
    }

    protected String protectedMethod(){
        return "Executing protected";
    }

}
