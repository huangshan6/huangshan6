package com.example.demo.liuxinyu.service;


import com.example.demo.liuxinyu.entity.Classroom;
import com.example.demo.liuxinyu.entity.NotFoundException;
import com.example.demo.liuxinyu.entity.Classroom;
import com.example.demo.liuxinyu.entity.Student;
import com.example.demo.liuxinyu.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final RedisServiceClassroom redisService;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository, RedisServiceClassroom redisService) {
        this.classroomRepository = classroomRepository;
        this.redisService = redisService;
    }

    // 添加班级信息

    @Transactional
    public Classroom addClassroom(Classroom classroom) {
        // 检查是否已经存在相同班级名的班级
        if (classroomRepository.existsByName(classroom.getName())) {
            throw new IllegalArgumentException("班级名已经存在，请使用其他班级名。");
        }

        Classroom savedClassroom = classroomRepository.save(classroom);
        redisService.addClassroomToCache(savedClassroom);
        return savedClassroom;
    }

    // 根据ID获取班级信息，先查缓存，再查数据库
    public Classroom getClassroomById(int classId) {
        Classroom classroom = redisService.getClassroomFromCache(classId);
        if (classroom == null) {
            classroom = classroomRepository.findById(classId).orElse(null);
            if (classroom != null) {
                redisService.addClassroomToCache(classroom);
            }
        }
        return classroom;
    }
    // 更新班级信息，并更新缓存
    @Transactional
    public Classroom updateClassroom(Classroom  classroom) {
        Classroom updatedClassroom = classroomRepository.save(classroom);
        redisService.updateClassroomInCache(updatedClassroom);
        return updatedClassroom;
    }


    @Transactional
    public void deleteClassroom(int classId) {
        Optional<Classroom> classroomOptional = classroomRepository.findById(classId);
        if (classroomOptional.isPresent()) {
            // 如果存在该班级
            classroomRepository.deleteById(classId);
            redisService.deleteClassroomFromCache(classId);
        } else {
            // 抛出自定义异常
            throw new NotFoundException("Classroom with classId " + classId + " not found.");
        }
    }

}

