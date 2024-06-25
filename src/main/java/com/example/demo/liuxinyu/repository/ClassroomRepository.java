package com.example.demo.liuxinyu.repository;

import com.example.demo.liuxinyu.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {


    boolean existsByName(String name);

}
