package org.example.aop.xml;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public void add(){
        System.out.println("Book add ...");
    }
}
