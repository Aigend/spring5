package org.example.liftcircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("步骤3：初始化前，把bean的实例传递给bean后置处理器方法（需要添加后置处理器，创建类实现BeanPostProcessor）");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("步骤5：初始化后，把bean的实例传递给bean后置处理器方法（需要添加后置处理器，创建类实现BeanPostProcessor）");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
