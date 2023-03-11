package org.example.testannoation.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller // 可以什么都不写，value值默认为为类名称首字母小写
public class DemoAnnoation {
    public void test(){
        System.out.println("demoAnnoation test ...");
    }

    @Override
    public String toString() {
        return "@##########";
    }
}
