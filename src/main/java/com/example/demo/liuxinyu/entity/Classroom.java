package com.example.demo.liuxinyu.entity;


import javax.persistence.*;

@Entity
@Table(name = "classroom") // 指定表名

public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name", nullable = false, unique = true)
    private String name;

    @Column(name = "grade")
    private int grade;

    @Column(name = "teacher")
    private String teacher;

    public Classroom(int classId, String name, int grade, String teacher) {
        this.classId = classId;
        this.name = name;
        this.grade = grade;
        this.teacher = teacher;
    }

    public Classroom() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}