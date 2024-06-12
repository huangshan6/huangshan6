package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.zangqingran.Classroom;
import com.example.demo.zangqingran.Student;
import com.example.demo.zangqingran.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testGetStudentInfo() throws Exception {
        // Mock data
        Student student = new Student(1, "张三", 20, 1);
        Classroom classroom = new Classroom(1, "1班", "三年级", "李老师");

        when(studentService.getStudent(1)).thenReturn(student);
        when(studentService.getClassroom(1)).thenReturn(classroom);

        mockMvc.perform(get("/api/student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentId").value(1))
                .andExpect(jsonPath("$.studentName").value("张三"))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.classId").value(1))
                .andExpect(jsonPath("$.className").value("1班"))
                .andExpect(jsonPath("$.grade").value("三年级"))
                .andExpect(jsonPath("$.classTeacherName").value("李老师"));
    }
}
