package com.example.demo.liuxinyu;

public class ResponseObject {
//    private String studentId;
//    private String studentName;
//    private int age;
//    private String classId;
//    private String className;
//    private int grade;
//    private String teacherName;

private Student student;
private  Classroom classroom;

//    public ResponseObject(String studentId, String studentName, int age, String classId, String className, int grade, String teacherName) {
//        this.studentId = studentId;
//        this.studentName = studentName;
//        this.age = age;
//        this.classId = classId;
//        this.className = className;
//        this.grade = grade;
//        this.teacherName = teacherName;
//    }

    public ResponseObject(Student student, Classroom classroom) {
        this.student = student;
        this.classroom = classroom;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

}