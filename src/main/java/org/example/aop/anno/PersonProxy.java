package org.example.aop.anno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//配置多个增强类，设置他们的优先级
@Order(1)
@Aspect
@Component
public class PersonProxy {
    @Before(value = "execution(* org.example.aop.anno.User.add(..))")
    public void before(){
        System.out.println("PersonProxy before:...");
    }
    @After(value = "execution(* org.example.aop.anno.User.add(..))")
    public void after(){
        System.out.println("PersonProxy after:...");
    }

}
