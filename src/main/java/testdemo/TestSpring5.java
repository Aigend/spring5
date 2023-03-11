package testdemo;

import org.example.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd(){
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("D:\wenlong\JavaProject\spring5_demo1\src\main\resources\bean.xml");

        //获取配置的创建对象
        User user = context.getBean("user", User.class);

        System.out.println(user);

        user.add();

    }
}
