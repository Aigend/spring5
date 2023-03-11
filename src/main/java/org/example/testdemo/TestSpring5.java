package org.example.testdemo;

import org.example.User;
import org.example.autowire.Emp;
import org.example.collecationtype.Book;
import org.example.collecationtype.Stu;
import org.example.factbean.Course;
import org.example.factbean.MyBean;
import org.example.liftcircle.Orders;
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

    /**
     * 注释的添加方法，敲/**后回车即可
     * 工厂bean
     */
    @Test
    public void testMyBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean);
    }

    @Test
    public void testCollecation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Stu s = context.getBean("stu", Stu.class);
        s.test();
        ApplicationContext bookcontext = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = bookcontext.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testCollecation2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1);
        System.out.println(user2);
        /**
         * 通过打印的地址观察发现 2个对象地址相同，默认作用域为单实例：singleton
         * scope 如果配置为prototype,为多实例对象，不是在加载spring bean文件的时候创建对象，而是在调用getBean方法时创建
         * scope 如果配置为singleton,为单实例对象，加载spring bean 配置文件的时候创建单实例对象
         *       request:放到request中
         *       session:对象放到session中
         *
         * org.example.User@15b3e5b
         * org.example.User@15b3e5b
         * **/
        User user3 = context.getBean("userp", User.class);
        User user4 = context.getBean("userp", User.class);
        System.out.println(user3);
        System.out.println(user4);
        /**
         * 这里是不同对象
         * org.example.User@61ca2dfa
         * org.example.User@4b53f538
         */

    }

    @Test
    public void testLiftCircle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Orders orders = context.getBean("orders", Orders.class);
        orders.test();
        //向下转换调用close方法
        ((ClassPathXmlApplicationContext) context).close();
    }


    @Test
    public void testAutoWire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

}
