package com.example.demo.liuxinyu.services;

import com.example.demo.liuxinyu.entity.Student;
import com.example.demo.liuxinyu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // 创建学生
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // 获取所有学生
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 通过ID获取学生
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    // 更新学生信息
    public Student updateStudent(String id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAge(updatedStudent.getAge());
                    student.setClassroomid(updatedStudent.getClassroomid());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    updatedStudent.setId(id);
                    return studentRepository.save(updatedStudent);
                });
    }

    // 删除学生
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
