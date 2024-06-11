package com.example.demo;
public class StudentResponse {
    private int studentId;
    private String studentName;
    private int age;
    private int classId;
    private String className;
    private String grade;
    private String classTeacherName;

    public StudentResponse(Student student, Classroom classroom) {
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.age = student.getAge();
        this.classId = student.getClassId();
        this.className = classroom.getClassName();
        this.grade = classroom.getGrade();
        this.classTeacherName = classroom.getClassTeacherName();
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
