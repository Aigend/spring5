package org.example.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.example.aop.anno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
