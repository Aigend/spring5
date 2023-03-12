package org.example.aop.xml;

import org.springframework.stereotype.Component;

@Component
public class BookProxy {
    public void before(){
        System.out.println("BookProxy Before ...");
    }
}
