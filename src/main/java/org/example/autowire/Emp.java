package org.example.autowire;

public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{"+"dept="+dept+"}";
    }
    void test(){
        System.out.println(dept);
    }
}
