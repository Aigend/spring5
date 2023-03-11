package org.example.collecationtype;

public class Course {
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String cname;

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
