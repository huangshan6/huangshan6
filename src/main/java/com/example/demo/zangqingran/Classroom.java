package com.example.demo;
public class Classroom {
    private int classId;
    private String className;
    private String grade;
    private String classTeacherName;

    public Classroom(int classId, String className, String grade, String classTeacherName) {
        this.classId = classId;
        this.className = className;
        this.grade = grade;
        this.classTeacherName = classTeacherName;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getGrade() {
        return grade;
    }

    public String getClassTeacherName() {
        return classTeacherName;
    }
}
