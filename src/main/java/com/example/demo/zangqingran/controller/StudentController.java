package com.example.demo.zangqingran.controller;


import com.example.demo.zangqingran.entity.Student;
import com.example.demo.zangqingran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/api/student/{id}")
    public Student getStudentInfo(@PathVariable int id) {
        if (studentRepository.existsById(id)) {
            Optional<Student> student = studentRepository.findById(id);
            return student.get();
        }else
            return null;
    }
    @GetMapping("/api/student")
    public List<Student> getAllStudent(){
        List<Student> list = (List<Student>) studentRepository.findAll();
        return  list;
    }
    //处理"/student/"的POST请求，用来创建student
    @PostMapping("/api/stdent/add")
    public String addstudent( @RequestBody Student student ) {
        studentRepository.save(student);
        return "success";
    }
    //处理"/student/{id}"的PUT请求，用来更新student信息
    @PutMapping("/{id}")
    public String updatestudent( @PathVariable int id, @RequestBody Student student ) {
        Student student_ = studentRepository.findById(id).get();
        student_.setStudentName(student.getStudentName());
        student_.setAge(student.getAge());
        studentRepository.save(student_);
        return "success";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "success";
    }

}
