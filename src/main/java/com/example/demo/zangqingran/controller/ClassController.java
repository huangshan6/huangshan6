package com.example.demo.zangqingran.controller;

import com.example.demo.zangqingran.entity.ClassRoom;
import com.example.demo.zangqingran.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassController {

    @Autowired
    ClassRepository classesRepository;

    @GetMapping("/api/classes/{id}")
    public ClassRoom getClassInfo(@PathVariable int id) {
        if (classesRepository.existsById(id)) {
            Optional<ClassRoom> classes = classesRepository.findById(id);
            return classes.get();
        }else
            return null;
    }
    @GetMapping("/api/classes")
    public List<ClassRoom> getAllClass(){
        List<ClassRoom> list = (List<ClassRoom>) classesRepository.findAll();
        return  list;
    }
    //处理"/classes/"的POST请求，用来创建classes
    @PostMapping("/api/stdent/add")
    public String addclasses( @RequestBody ClassRoom classes ) {
        classesRepository.save(classes);
        return "success";
    }
    //处理"/classes/{id}"的PUT请求，用来更新classes信息
    @PutMapping("/{id}")
    public String updateclasses( @PathVariable int id, @RequestBody ClassRoom classes ) {
        ClassRoom classes_ = classesRepository.findById(id).get();
        classes_.setClassName(classes.getClassName());
        classes_.setGrade(classes.getGrade());
        classes_.setClassTeacherName(classes.getClassTeacherName());
        classesRepository.save(classes_);
        return "success";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        classesRepository.deleteById(id);
        return "success";
    }

}
