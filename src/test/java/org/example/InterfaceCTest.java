
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InterfaceCTest {

    @Test
    public void testGetCombinedDetails() {
        // 创建模拟的学生和班级对象
        Student studentMock = mock(Student.class);
        when(studentMock.getStudentId()).thenReturn("1001");
        when(studentMock.getName()).thenReturn("张三");
        when(studentMock.getAge()).thenReturn(18);
        when(studentMock.getClassId()).thenReturn("A001");

        Classroom classMock = mock(Classroom.class);
        when(classMock.getClassId()).thenReturn("A001");
        when(classMock.getName()).thenReturn("一年级一班");
        when(classMock.getGrade()).thenReturn(1);
        when(classMock.getTeacherName()).thenReturn("李老师");

        // 调用被测试的方法
        String[] combinedDetails = InterfaceC.getCombinedDetails(studentMock, classMock);

        // 验证返回的数组是否包含七个元素
        assertEquals(7, combinedDetails.length);

        // 验证各个元素的值是否正确
        assertEquals("1001", combinedDetails[0]); // 学生ID
        assertEquals("张三", combinedDetails[1]); // 学生姓名
        assertEquals("18", combinedDetails[2]); // 年龄
        assertEquals("A001", combinedDetails[3]); // 班级ID
        assertEquals("一年级一班", combinedDetails[4]); // 班级名
        assertEquals("1", combinedDetails[5]); // 年级
        assertEquals("李老师", combinedDetails[6]); // 班主任名
    }
}
