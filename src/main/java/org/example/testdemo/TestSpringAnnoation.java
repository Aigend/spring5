package org.example.testdemo;

import org.example.testannoation.service.DemoAnnoation;
import org.example.testannoation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAnnoation {

    @Test
    public void testDemo(){

        //全部扫描，扫描到demo
        ApplicationContext context = new ClassPathXmlApplicationContext("annoation.xml");
        DemoAnnoation demoAnnoation = context.getBean("demoAnnoation", DemoAnnoation.class);
        demoAnnoation.test();
        ((ClassPathXmlApplicationContext) context).close();
        // 扫描包含@Controller 扫描到demo
        ApplicationContext context1 = new ClassPathXmlApplicationContext("annoation1.xml");
        DemoAnnoation demoAnnoation1 = context1.getBean("demoAnnoation", DemoAnnoation.class);
        demoAnnoation1.test();
        ((ClassPathXmlApplicationContext) context1).close();
        // 扫描不包含@Controller，扫描不到demo
        ApplicationContext context2 = new ClassPathXmlApplicationContext("annoation2.xml");
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'demoAnnoation' available
//        DemoAnnoation demoAnnoation2 = context2.getBean("demoAnnoation", DemoAnnoation.class);
        ((ClassPathXmlApplicationContext) context2).close();
    }

    @Test
    public void testUserService(){
        //全部扫描
        ApplicationContext context = new ClassPathXmlApplicationContext("annoation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testUserServiceResource(){
        //全部扫描
        ApplicationContext context = new ClassPathXmlApplicationContext("annoation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.testResource();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testValue(){
        //全部扫描
        ApplicationContext context = new ClassPathXmlApplicationContext("annoation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.testValue();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
