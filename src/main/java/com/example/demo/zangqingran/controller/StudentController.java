package com.example.demo.zangqingran.controller;


import com.example.demo.zangqingran.entity.ClassRoom;
import com.example.demo.zangqingran.entity.Student;
import com.example.demo.zangqingran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Resource
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
    @PostMapping("/api/student/add")
    public String addstudent( @RequestParam int studentID,@RequestParam String studentName,@RequestParam int age,@RequestParam int classID) {
        Student student = new Student(studentID,studentName,age,classID);
        studentRepository.save(student);
        return "success";
    }
    //处理"/student/{id}"的PUT请求，用来更新student信息
    @PutMapping("/api/student/edit/{id}/{studentName}/{age}/{classID}")
    public String updatestudent( @PathVariable int id, @PathVariable String studentName,@PathVariable int age,@PathVariable int classID) {
        Student student_ = studentRepository.findById(id).get();
        student_.setStudentName(studentName);
        student_.setAge(age);
        student_.setClassId(classID);
        studentRepository.save(student_);
        return "success";
    }
    @DeleteMapping("/api/student/delete/{id}")
    public String delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "success";
    }

}
