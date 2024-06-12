package com.example.demo.liuxinyu;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String classId;


    public Student() {
    }

    public Student(String studentId, String name, int age, String classId) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.classId = classId;
    }

    /**
     * 获取
     * @return studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置
     * @param classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String toString() {
        return "Student{studentId = " + studentId + ", name = " + name + ", age = " + age + ", classId = " + classId + "}";
    }
}