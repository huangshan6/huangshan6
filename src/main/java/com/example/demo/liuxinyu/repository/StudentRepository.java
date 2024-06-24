package com.example.demo.liuxinyu.repository;

import com.example.demo.liuxinyu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByClassroomid(String classroomid);
}
