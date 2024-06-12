package org.example;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    public MyRepository() {
        System.out.println("5、MyRepository Constructor");
    }

    public void fetchData() {
        System.out.println("5、MyRepository fetching data");
    }
}
