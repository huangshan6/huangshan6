package com.example.demo.liuxinyu;

//import com.example.demo.model.Classroom;
//import com.example.demo.model.ResponseObject;
//import com.example.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentClassController.class)
public class StudentClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StudentClassController studentClassController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudentInfo() throws Exception {
        mockMvc.perform(get("/api/studentInfo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.student.studentId").value("002"))
                .andExpect(jsonPath("$.student.name").value("小明"))
                .andExpect(jsonPath("$.student.age").value(18))
                .andExpect(jsonPath("$.student.classId").value("1001"))
                .andExpect(jsonPath("$.classroom.classId").value("1001"))
                .andExpect(jsonPath("$.classroom.name").value("一年级一班"))
                .andExpect(jsonPath("$.classroom.grade").value(1))
                .andExpect(jsonPath("$.classroom.teacherName").value("张老师"));
    }
}
