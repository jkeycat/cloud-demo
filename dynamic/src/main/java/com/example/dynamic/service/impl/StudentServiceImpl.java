package com.example.dynamic.service.impl;

import com.example.dynamic.entity.Student;
import com.example.dynamic.mapper.StudentMapper;
import com.example.dynamic.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
