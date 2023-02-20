package com.example.dynamic;

import com.example.dynamic.config.MonthTableNameHandler;
import com.example.dynamic.entity.Student;
import com.example.dynamic.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicApplicationTests {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        MonthTableNameHandler.setMonthData("202209");
        Student student = studentMapper.selectById("2");
        System.out.println(student);
        MonthTableNameHandler.removeData();
    }

}
