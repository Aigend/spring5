package org.example.liftcircle;

public class Orders {


    private String onname;

    public Orders() {
        System.out.println("步骤1：调用构造器进行初始化");
    }

    public void setOnname(String onname) {
        System.out.println("步骤2：调用set方法进行属性配置");
        this.onname = onname;
    }

    //创建执行的初始化的方法
    public void initMethod(){
        System.out.println("步骤4：创建执行初始化的方法");
    }

    public void test(){
        System.out.println("步骤6：对象可以使用了");
    }

    public void destroyMethod(){
        System.out.println("步骤7：容器关闭后执行销毁方法");
    }

}
