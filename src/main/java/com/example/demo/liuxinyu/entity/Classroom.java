package com.example.demo.liuxinyu.entity;

import javax.persistence.*;


@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // 班级名称
    private String name;

    // 年级
    private int grade;

    // 班主任名称
    private String headteacher;

    public Classroom(String id, String name, int grade, String headteacher) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.headteacher = headteacher;
    }

    public Classroom() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHeadteacher() {
        return headteacher;
    }

    public void setHeadteacher(String headteacher) {
        this.headteacher = headteacher;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", headteacher='" + headteacher + '\'' +
                '}';
    }


}


