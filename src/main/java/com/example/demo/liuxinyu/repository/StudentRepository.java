package com.example.demo.liuxinyu.repository;

import com.example.demo.liuxinyu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {



}