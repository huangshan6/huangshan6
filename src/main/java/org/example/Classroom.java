package org.example;

public class Classroom {
    private String classId;
    private String name;
    private int grade;
    private String teacherName;


    public Classroom() {
    }

    public Classroom(String classId, String name, int grade, String teacherName) {
        this.classId = classId;
        this.name = name;
        this.grade = grade;
        this.teacherName = teacherName;
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
     * @return grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * 设置
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * 获取
     * @return teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String toString() {
        return "Classroom{classId = " + classId + ", name = " + name + ", grade = " + grade + ", teacherName = " + teacherName + "}";
    }
}
