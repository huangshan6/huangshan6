package com.example.demo.liuxinyu.controller;

import com.example.demo.liuxinyu.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectController {

    private final ClassroomService classroomService;

    @Autowired
    public ConnectController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classroom/{classroomId}/students")
    public String getStudentsNames(@PathVariable String classroomId) {
        return classroomService.getStudentsNamesByClassroomId(classroomId);
    }
}