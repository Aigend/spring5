package org.example.aop.anno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Order(3)
@Aspect
@Component
public class UserProxy {

    //相同切入点抽取，改表达式比较方便
    @Pointcut(value = "execution(* org.example.aop.anno.User.add(..))")
    public void pointdemo(){

    }


    /**
     * 前置通知
     * @Before 表示前置通知
     *
     */
//    @Before(value = "execution(* org.example.aop.anno.User.add(..))")
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before:...");
    }

    //方法执行之后执行,不管有没有异常都执行，有异常的话，执行after后会执行afterThrowing
    @After(value = "execution(* org.example.aop.anno.User.add(..))")
    public void after(){
        System.out.println("after:...");
    }

    //方法返回值之后执行，有异常就不执行
    @AfterReturning(value = "execution(* org.example.aop.anno.User.add(..))")
    public void afterRetuning(){
        System.out.println("afterRetuning:...");
    }

    //有异常之后执行
    @AfterThrowing(value = "execution(* org.example.aop.anno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing:...");
    }

    //环绕通知
    @Around(value = "execution(* org.example.aop.anno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("around:环绕之前...");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("around:环绕之后");
    }


}
