package com.gfg.demo;

public class DIDemo {

    public static void main(String[] args) {

        Car car1 = new Car();
        car1.run();


        Car car2 = new Car();
        car2.run();

        Engine engine1 = new Engine("Mega Power",1500);

        Engine engine2 = new Engine("Super Power",2500);


        Car car3 = new Car("Nexon", engine1);
        car3.run();


        Car car4 = new Car("Hexa",engine2);
        car4.run();

        BS5Engine bs5Engine = new BS5Engine("MegaBS5", 2000);
        Car car5 = new Car("Harier BS5", bs5Engine);
        car5.run();

    }
}
