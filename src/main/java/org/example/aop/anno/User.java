package org.example.aop.anno;


//被增强的类

import org.springframework.stereotype.Component;

@Component
public class User {


    public void add(){
        System.out.println("User add .......");
    }
}
