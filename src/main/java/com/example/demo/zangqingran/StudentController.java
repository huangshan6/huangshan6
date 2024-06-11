package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/api/student/{id}")
    public StudentResponse getStudentInfo(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        Classroom classroom = studentService.getClassroom(student.getClassId());
        return new StudentResponse(student, classroom);
    }
}
