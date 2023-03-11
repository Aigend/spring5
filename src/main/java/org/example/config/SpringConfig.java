package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //作为配置类，替代xml文件
@ComponentScan(basePackages = {"org.example.testannoation"}) //配置扫描的包
public class SpringConfig {
}
