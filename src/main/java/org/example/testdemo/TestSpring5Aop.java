package org.example.testdemo;

import org.example.aop.anno.User;
import org.example.aop.config.ConfigAop;
import org.example.aop.xml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Aop {
    @Test
    public void testAspectjAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopaspect.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }

    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopxml.xml");
        Book book = context.getBean("book", Book.class);
        book.add();

    }

    @Test
    public void testAopConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add();

    }

}
