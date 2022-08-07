package com.baiyun.smartcampus.service;

import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;

public interface StudentService extends IService<Student> {
    Student login(LoginForm loginForm);

    Student getStudentById(Long userId);
}
