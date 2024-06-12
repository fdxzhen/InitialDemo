package org.example;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class MyService {

    public MyService() {
        System.out.println("6、MyService default Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("6、MyService PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MyService PreDestroy");
    }

    public void doSomething() {
        System.out.println("MyService doing something");
    }
}
