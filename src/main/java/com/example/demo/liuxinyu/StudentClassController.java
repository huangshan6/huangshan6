package com.example.demo.liuxinyu;


//import com.example.demo.model.Classroom;
//import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentClassController {

    // 模拟数据
    private Student student = new Student("002", "小明", 18, "1001");
    private Classroom classroom = new Classroom("1001", "一年级一班", 1, "张老师");

    @GetMapping("/api/studentInfo")
    public ResponseObject getStudentInfo() {
        return new ResponseObject(student, classroom);
    }
}