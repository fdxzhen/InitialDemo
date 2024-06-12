package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("0、start");

//        SpringApplication.run(Main.class, args);
        System.out.println("end");


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MyService myService = context.getBean(MyService.class);
        myService.doSomething();;
    }
}
