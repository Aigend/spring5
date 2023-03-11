package org.example.collecationtype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    private String[] courses;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    private Map<String, String> map;

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    private Set<String> set;


    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    private List<Course> courseList;


    public void test(){
        System.out.println(Arrays.toString(this.courses));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println("***");
        System.out.println(courseList);
    }
}
