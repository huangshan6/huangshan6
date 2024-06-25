package com.example.demo.liuxinyu.service;

import com.example.demo.liuxinyu.entity.NotFoundException;
import com.example.demo.liuxinyu.entity.Student;
import com.example.demo.liuxinyu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RedisServiceStudent redisService;

    @Autowired
    public StudentService(StudentRepository studentRepository, RedisServiceStudent redisService) {
        this.studentRepository = studentRepository;
        this.redisService = redisService;
    }

    // 添加学生信息
    @Transactional
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        redisService.addStudentToCache(savedStudent);
        return savedStudent;
    }

    // 根据ID获取学生信息，先查缓存，再查数据库
    public Student getStudentById(int id) {
        Student student = redisService.getStudentFromCache(id);
        if (student == null) {
            student = studentRepository.findById(id).orElse(null);
            if (student != null) {
                redisService.addStudentToCache(student);
            }
        }
        return student;
    }

    // 更新学生信息，并更新缓存
    @Transactional
    public Student updateStudent(Student student) {
        Student updatedStudent = studentRepository.save(student);
        redisService.updateStudentInCache(updatedStudent);
        return updatedStudent;
    }

    @Transactional
    public void deleteStudent(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            // 如果存在该学生
            studentRepository.deleteById(id);
            redisService.deleteStudentFromCache(id);
        } else {
            // 抛出自定义异常
            throw new NotFoundException("Student with ID " + id + " not found.");
        }
    }

}

