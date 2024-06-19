package com.example.demo.liuxinyu.services;

import com.example.demo.liuxinyu.entity.Classroom;

import com.example.demo.liuxinyu.entity.Student;
import com.example.demo.liuxinyu.repository.ClassroomRepository;
import com.example.demo.liuxinyu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final  StudentRepository studentRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    public String getStudentsNamesByClassroomId(String classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Classroom ID"));
        List<Student> students = studentRepository.findByClassroomid(classroomId);
        return students.stream()
                .map(Student::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
    }

    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    public Optional<Classroom> findById(String id) {
        return classroomRepository.findById(id);
    }

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public boolean deleteById(String id) {
        classroomRepository.deleteById(id);
        return true;
    }

}
