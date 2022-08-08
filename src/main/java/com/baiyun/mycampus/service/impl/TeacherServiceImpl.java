package com.baiyun.mycampus.service.impl;


import com.baiyun.mycampus.mapper.TeacherMapper;
import com.baiyun.mycampus.pojo.LoginForm;
import com.baiyun.mycampus.pojo.Teacher;
import com.baiyun.mycampus.service.TeacherService;
import com.baiyun.mycampus.utils.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Override
    public IPage<Teacher> getTeacherByOpr(Page<Teacher> pageParam, Teacher teacher) {

        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<Teacher>();
        if (!StringUtils.isEmpty(teacher.getName())) {
            teacherQueryWrapper.like("name",teacher.getName());
        }
        if (!StringUtils.isEmpty(teacher.getClazzName())) {
            teacherQueryWrapper.like("clazz_name",teacher.getClazzName());
        }

        teacherQueryWrapper.orderByDesc("id");
        Page<Teacher> page = baseMapper.selectPage(pageParam,teacherQueryWrapper);

        return page;
    }
}
