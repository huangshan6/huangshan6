package com.example.demo.liuxinyu.controller;

import com.example.demo.liuxinyu.entity.NotFoundException;
import com.example.demo.liuxinyu.entity.Student;
import com.example.demo.liuxinyu.service.RedisServiceStudent;
import com.example.demo.liuxinyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final RedisServiceStudent redisService;

    @Autowired
    public StudentController(StudentService studentService, RedisServiceStudent redisService) {
        this.studentService = studentService;
        this.redisService = redisService;
    }

    // 添加学生，并存入Redis
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        redisService.addStudentToCache(savedStudent);
        return savedStudent;
    }

    // 从Redis获取学生信息
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        Student student = redisService.getStudentFromCache(id);
        if (student == null) {
            // 缓存未命中，从数据库获取并更新缓存
            student = studentService.getStudentById(id);
            redisService.addStudentToCache(student);
        }
        return student;
    }

    // 更新学生信息，同时更新Redis缓存
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id); // 确保更新的学生ID匹配
        Student updatedStudent = studentService.updateStudent(student);
        redisService.updateStudentInCache(updatedStudent);
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete student with ID " + id + ": " + e.getMessage());
        }
    }
}
