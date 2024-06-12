package com.example.demo.zangqingran;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student getStudent(int id) {
        // Mock data, replace with actual database call
        return new Student(id, "张三", 20, 1);
    }

    public Classroom getClassroom(int classId) {
        // Mock data, replace with actual database call
        return new Classroom(1, "1班", "三年级", "李老师");
    }
}
