package org.example;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public MyComponent() {
        System.out.println("4、MyComponent Constructor");
    }

    public void performTask() {
        System.out.println("4、MyComponent performing task");
    }
}
