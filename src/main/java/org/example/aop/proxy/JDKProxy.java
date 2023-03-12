package org.example.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        //
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        System.out.println("***");
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));
        userDao.add(1, 2);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler{

    //1. 把创建的是谁的代理对象，把谁传过来
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy);
        // 方法之前执行
        System.out.println("方法之前执行:"+method.getName()+",执行传递的参数："+ Arrays.toString(args));

        //方法执行
        Object res = method.invoke(obj, args);

        //方法之后执行
        System.out.println("方法执行之后执行..."+obj);


        return res;
    }
}
