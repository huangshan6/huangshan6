package com.example.demo.liuxinyu.service;

import com.example.demo.liuxinyu.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceClassroom {


    private final RedisTemplate<String, Classroom> redisTemplateClassroom;

    @Autowired
    public RedisServiceClassroom(RedisTemplate<String, Classroom> classroomredisTemplate) {
        this.redisTemplateClassroom = classroomredisTemplate;
    }

//    public void addClassroomToCache(Classroom savedClassroom) {
//        ValueOperations<String, Classroom> valueOperations = redisTemplateClassroom.opsForValue();
//        valueOperations.set("classroom:" + savedClassroom.getClassId(), savedClassroom);
//    }

    public void addClassroomToCache(Classroom savedclassroom) {
        redisTemplateClassroom.opsForValue().set("classroom:" + savedclassroom.getClassId(), savedclassroom);
    }

    public Classroom getClassroomFromCache(int classId) {
        ValueOperations<String, Classroom> valueOperations = redisTemplateClassroom.opsForValue();
        return valueOperations.get("classroom:" + classId);
    }

    public void updateClassroomInCache(Classroom updatedClassroom) {
        this.addClassroomToCache(updatedClassroom);
    }

    public void deleteClassroomFromCache(int classId) {
        redisTemplateClassroom.delete("classroom:" + classId);
    }
}



