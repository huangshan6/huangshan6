package com.example.demo.liuxinyu;

public class InterfaceC {
    public static String[] getCombinedDetails(Student student, Classroom classroom) {
        String[] studentDetails = getStudentDetails(student);
        String[] classDetails = getClassDetails(classroom);
        String[] combinedDetails = new String[7];

        combinedDetails[0] = studentDetails[0]; // 学生ID
        combinedDetails[1] = studentDetails[1]; // 学生姓名
        combinedDetails[2] = studentDetails[2]; // 年龄
        combinedDetails[3] = studentDetails[3]; // 班级ID
        combinedDetails[4] = classDetails[1]; // 班级名
        combinedDetails[5] = classDetails[2]; // 年级
        combinedDetails[6] = classDetails[3]; // 班主任名

        return combinedDetails;
    }

    public static String[] getStudentDetails(Student student) {
        String[] details = new String[4];
        details[0] = student.getStudentId();
        details[1] = student.getName();
        details[2] = String.valueOf(student.getAge());
        details[3] = student.getClassId();
        return details;
    }

    public static String[] getClassDetails(Classroom classroom) {
        String[] details = new String[4];
        details[0] = classroom.getClassId();
        details[1] = classroom.getName();
        details[2] = String.valueOf(classroom.getGrade());
        details[3] = classroom.getTeacherName();
        return details;
    }
}
