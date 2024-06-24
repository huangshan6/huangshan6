package com.example.demo.zangqingran.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ClassRoom {
    @Id
    private int classId;
    @Column(nullable = false, unique = true, length = 20)
    private String className;
    @Column(nullable = false, length = 20)
    private String grade;
    @Column(nullable = false, length = 20)
    private String classTeacherName;

    public ClassRoom(int classId, String className, String grade, String classTeacherName) {
        this.classId = classId;
        this.className = className;
        this.grade = grade;
        this.classTeacherName = classTeacherName;
    }

    public ClassRoom() {

    }


    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setClassTeacherName(String classTeacherName) {
        this.classTeacherName = classTeacherName;
    }

    public String getGrade() {
        return grade;
    }

    public String getClassTeacherName() {
        return classTeacherName;
    }
}
