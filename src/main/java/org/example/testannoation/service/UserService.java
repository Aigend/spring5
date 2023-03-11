package org.example.testannoation.service;

import org.example.testannoation.dao.UserDao;
import org.example.testannoation.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService") //<bean id="userService" class="..."/>
public class UserService {

    @Value("abc")
    private String name;
    @Autowired //添加注入属性注解， 不需要再添加set方法
    @Qualifier("userDaoImpl2")
    private UserDao userDao;

    //使用注解方式不需要添加set方法
//    public UserDao getUserDao() {
//        return userDao;
//    }

//    @Resource // 根据类型注入，因为多个类型，这里会报错
//    private UserDao userDaoRes;

    @Resource(name="userDaoImpl2")
    private UserDao userDaoRes;

    public void add(){
        System.out.println("service add ...");
        userDao.add();
    }

    public void testResource(){
        System.out.println("service test ...");
        userDaoRes.add();
    }

    public void testValue(){
        System.out.println("service name:"+name);
    }
}
