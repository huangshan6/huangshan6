package com.example.demo.zangqingran.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "student")
@Data
public class Student {
    @Id
    private int studentId;
    //指定实体类中主键是谁
   // @GeneratedValue(strategy = GenerationType.IDENTITY)主键自增
    @Column(nullable = false, unique = true, length = 20)
    private String studentName;
    @Column(nullable = false, length = 20)
    private int age;
    @Column(nullable = false, unique = true, length = 20)
    private int classId;

    public Student(int studentId, String studentName, int age, int classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.classId = classId;
    }

    public Student() {

    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public int getClassId() {
        return classId;
    }
}