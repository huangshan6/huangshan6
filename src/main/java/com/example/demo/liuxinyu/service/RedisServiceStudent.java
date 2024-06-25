package com.example.demo.liuxinyu.service;

import com.example.demo.liuxinyu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceStudent {

    @Autowired
    private RedisTemplate<String, Student> redisTemplateStudent;

    public RedisServiceStudent(RedisTemplate<String, Student> studentredisTemplate) {
        this.redisTemplateStudent = studentredisTemplate;
    }

    public void addStudentToCache(Student student) {
        ValueOperations<String, Student> valueOperations = redisTemplateStudent.opsForValue();
        valueOperations.set("student:" + student.getId(), student);
    }

    public Student getStudentFromCache(int id) {
        ValueOperations<String, Student> valueOperations = redisTemplateStudent.opsForValue();
        return valueOperations.get("student:" + id);
    }

    public void deleteStudentFromCache(int id) {
        redisTemplateStudent.delete("student:" + id);
    }

    public void updateStudentInCache(Student student) {
        // Update operation in Redis is similar to deleting and then adding again
        deleteStudentFromCache(student.getId());
        addStudentToCache(student);
    }
}
