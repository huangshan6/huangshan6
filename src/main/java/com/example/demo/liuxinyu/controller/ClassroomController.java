package com.example.demo.liuxinyu.controller;

import ch.qos.logback.classic.Logger;
import com.example.demo.liuxinyu.entity.NotFoundException;
import com.example.demo.liuxinyu.entity.Classroom;
import com.example.demo.liuxinyu.service.ClassroomService;
import com.example.demo.liuxinyu.service.RedisServiceClassroom;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;
    private final RedisServiceClassroom redisService;
    private Logger logger;


    @Autowired
    public ClassroomController(ClassroomService classroomService, RedisServiceClassroom redisService) {
        this.classroomService = classroomService;
        this.redisService = redisService;
    }


@PostMapping
public ResponseEntity<String> addClassroom(@RequestBody Classroom classroom) {
    try {
        Classroom savedClassroom = classroomService.addClassroom(classroom);
        // 将数据存入Redis
        String key = "classroom:" + savedClassroom.getClassId(); // Redis中的键，这里假设使用了班级的ID作为键名
        redisService.addClassroomToCache(savedClassroom); // 使用RedisTemplate将班级对象保存到Redis中
        return new ResponseEntity<>("成功添加", HttpStatus.CREATED);
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>("添加失败，班级名重复", HttpStatus.BAD_REQUEST);
    }
}

    // 从Redis获取学生信息
    @GetMapping("/{classId}")
    public Classroom getClassroom(@PathVariable int classId) {
        Classroom classroom = redisService.getClassroomFromCache(classId);
        if (classroom == null) {
            // 缓存未命中，从数据库获取并更新缓存
            classroom = classroomService.getClassroomById(classId);
            redisService.addClassroomToCache(classroom);
        }
        return classroom;
    }

    // 更新学生信息，同时更新Redis缓存
    @PutMapping("/{classId}")
    public Classroom updateClassroom(@PathVariable int classId, @RequestBody Classroom classroom) {
        classroom.setClassId(classId); // 确保更新的学生ID匹配
        Classroom updatedClassroom = classroomService.updateClassroom(classroom);
        redisService.updateClassroomInCache(updatedClassroom);
        return updatedClassroom;
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<String> deleteClassroom(@PathVariable int classId) {
        try {
            classroomService.deleteClassroom(classId);
            return ResponseEntity.ok("Classroom with classId " + classId + " deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete classroom with ID " + classId + ": " + e.getMessage());
        }
    }
}
