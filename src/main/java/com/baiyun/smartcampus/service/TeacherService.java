package com.baiyun.smartcampus.service;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TeacherService extends IService<Teacher> {
    Teacher login(LoginForm loginForm);

    Teacher getTeacherById(Long userId);
}
