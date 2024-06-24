package com.example.demo.zangqingran.controller;

import com.example.demo.zangqingran.entity.ClassRoom;
import com.example.demo.zangqingran.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class ClassController {

    @Resource
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
    @PostMapping("/api/classes/add")
    public String addclasses( @RequestParam int classID,@RequestParam String className,@RequestParam String grade,@RequestParam String classTeacherName ) {
        ClassRoom classes = new ClassRoom(classID,className,grade,classTeacherName);
        classesRepository.save(classes);
        return "success";
    }
    //处理"/classes/{id}"的PUT请求，用来更新classes信息
    @PutMapping("/api/classes/edit/{id}/{className}/{grade}/{classtn}")
    public String updateclasses( @PathVariable int id,@PathVariable String className,@PathVariable String grade,@PathVariable String classtn) {
        ClassRoom classes = classesRepository.findById(id).get();
        classes.setClassName(className);
        classes.setGrade(grade);
        classes.setClassTeacherName(classtn);
        classesRepository.save(classes);
        return "success";
    }
    @DeleteMapping("/api/classes/delete/{id}/{className}/{grade}/{classtn}")
    public String delete(@PathVariable int id,@PathVariable String className,@PathVariable String grade,@PathVariable String classtn) {
        classesRepository.deleteById(id);
        return "success";
    }

}
