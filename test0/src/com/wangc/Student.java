package com.wangc;

/**
 * @ClassName Student
 * @Author 冲哥
 * @Date 2020/12/12 22:54
 **/
public class Student {
    private String sid;//学号
    private String name;//姓名
    private String age;//年龄
    private String addr;//地址

    public Student() {
    }

    public Student(String sid, String name, String age, String addr) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
