package com.example.demo.liuxinyu.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 或者使用UUID生成策略
    private String id;

    private String name; // 学生姓名
    private int age;     // 学生年龄
    private String classroomid; // 班级ID，外键关联

    // 无参构造函数
    public Student() {
    }

    // 全参构造函数
    public Student(String id, String name, int age, String classroomid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classroomid = classroomid;
    }

    // id的getter和setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // name的getter和setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // age的getter和setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // classroomid的getter和setter
    public String getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(String classroomid) {
        this.classroomid = classroomid;
    }

    // 重写toString方法，方便打印和调试
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classroomid='" + classroomid + '\'' +
                '}';
    }
}