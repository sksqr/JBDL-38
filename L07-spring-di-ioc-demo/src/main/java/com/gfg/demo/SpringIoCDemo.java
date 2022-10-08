package com.gfg.demo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringIoCDemo {

    public static void main(String[] args) {

//        Resource resource = new ClassPathResource("projectbeans.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//
//        Engine engine = (Engine) factory.getBean("engine2");
//
//        Car car = (Car) factory.getBean("car1");
//
//        car.run();


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
//        ApplicationContext context1 = new ClassPathXmlApplicationContext("projectbeans.xml");


        Car car = (Car) context.getBean("car1");
        car.run();

//
//        Engine engine1 = (Engine) context.getBean("engine2");
//
//
//        Engine engine2 = (Engine) context.getBean("engine2");
//
//        System.out.println(engine1.equals(engine2));



        Engine engine1 = (Engine) context.getBean("engine1");
        Engine engine2 = (Engine) context.getBean("engine1");
        System.out.println(engine1.equals(engine2));



        context.close();

    }
}

