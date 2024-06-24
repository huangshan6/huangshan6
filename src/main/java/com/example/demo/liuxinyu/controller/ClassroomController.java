package com.example.demo.liuxinyu.controller;

import com.example.demo.liuxinyu.entity.Classroom;
import com.example.demo.liuxinyu.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    // 获取所有班级
    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.findAll();
    }

    // 根据ID获取班级
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Classroom>> getClassroomById(@PathVariable String id) {
        return ResponseEntity.ok(classroomService.findById(id));
    }

    // 创建新班级
    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.save(classroom);
    }

    // 更新班级信息
    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable String id, @RequestBody Classroom classroom) {
        classroom.setId(id); // 确保更新的是正确的班级
        return ResponseEntity.ok(classroomService.save(classroom));
    }

    // 删除班级
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        classroomService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
