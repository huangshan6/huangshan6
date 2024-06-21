package com.example.demo.zangqingran;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

import com.example.demo.zangqingran.controller.StudentController;
import com.example.demo.zangqingran.entity.ClassRoom;
import com.example.demo.zangqingran.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;

public class StudentControllerTest {

    @Spy
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    public void before() {
//        // 启用mock
//        MockitoAnnotations.openMocks(this);
//        ReflectionTestUtils.setField(studentController, "studentService", studentService);
    }

    @Test
    public void testGetStudentInfo() {
        // Mock data
//        Student student = new Student(1, "张三", 20, 1);
//        ClassRoom classroom = new ClassRoom(1, "1班", "三年级", "李老师");
//
//        // 模拟行为
//        doReturn(student).when(studentService).getStudent(anyInt());
//        doReturn(classroom).when(studentService).getClassroom(anyInt());
//        // 建议不要使用when().thenReturn()，因为该用法会真实调用一次函数
////        when(studentService.getStudent(1)).thenReturn(student);
//        when(studentService.getClassroom(1)).thenReturn(classroom);

        // 调用函数
//        StudentResponse response = studentController.getStudentInfo(1);/
////
//        // 断言
//        assertNotNull(response);
//        assertEquals(1, response.getStudentId());
//        assertEquals("张三", response.getStudentName());
//        assertEquals(20, response.getAge());
//        assertEquals(1, response.getClassId());
//        assertEquals("1班", response.getClassName());
//        assertEquals("三年级", response.getGrade());
//        assertEquals("李老师", response.getClassTeacherName());
    }
}
