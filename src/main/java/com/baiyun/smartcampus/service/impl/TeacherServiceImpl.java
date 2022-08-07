package com.baiyun.smartcampus.service.impl;


import com.baiyun.smartcampus.mapper.TeacherMapper;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.pojo.Teacher;
import com.baiyun.smartcampus.service.TeacherService;
import com.baiyun.smartcampus.utils.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : TeacherServiceImpl
 * @description: description
 */

@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Teacher login(LoginForm loginForm) {

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Teacher teacher = baseMapper.selectOne(queryWrapper);
        return teacher;
    }

    @Override
    public Teacher getTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
        queryWrapper.eq("id",userId);

        return baseMapper.selectOne(queryWrapper);

    }
}
