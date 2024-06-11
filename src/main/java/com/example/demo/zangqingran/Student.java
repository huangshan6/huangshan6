package com.example.demo;
public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private int classId;

    public Student(int studentId, String studentName, int age, int classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
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