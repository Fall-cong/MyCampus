package com.baiyun.smartcampus.service.impl;


import com.baiyun.smartcampus.mapper.StudentMapper;

import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.pojo.Student;
import com.baiyun.smartcampus.service.StudentService;
import com.baiyun.smartcampus.utils.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : StudentServiceImpl
 * @description: description
 */

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Student student = baseMapper.selectOne(queryWrapper);
        return student;
    }

    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("id",userId);

        return baseMapper.selectOne(queryWrapper);
    }
}
