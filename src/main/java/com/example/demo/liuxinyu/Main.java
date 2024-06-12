package com.example.demo.liuxinyu;
public class Main {
    public static void main(String[] args) {
        Student student = new Student("1001", "张三", 18, "A001");
        Classroom classObj = new Classroom("A001", "一年级一班", 1, "李老师");

        // 获取组合后的详细信息
        String[] combinedDetails = InterfaceC.getCombinedDetails(student, classObj);

        // 输出组合后的详细信息
        System.out.println("学生ID：" + combinedDetails[0]);
        System.out.println("学生姓名：" + combinedDetails[1]);
        System.out.println("年龄：" + combinedDetails[2]);
        System.out.println("班级ID：" + combinedDetails[3]);
        System.out.println("班级名：" + combinedDetails[4]);
        System.out.println("年级：" + combinedDetails[5]);
        System.out.println("班主任名：" + combinedDetails[6]);
    }
}
