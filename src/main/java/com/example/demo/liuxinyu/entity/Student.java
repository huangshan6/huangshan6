package com.example.demo.liuxinyu.entity;


import javax.persistence.*;

@Entity
@Table(name = "student") // 指定表名

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "class_id")
    private int classId;

    public Student(String name, int id, int age, int classId) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.classId = classId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classId='" + classId + '\'' +
                ", id=" + id +
                '}';
    }
}