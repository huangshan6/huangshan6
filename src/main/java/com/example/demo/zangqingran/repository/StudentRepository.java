package com.example.demo.zangqingran.repository;

import com.example.demo.zangqingran.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  StudentRepository extends CrudRepository<Student,Integer> {
//   @Query(value = "select * from Student where ")
}
