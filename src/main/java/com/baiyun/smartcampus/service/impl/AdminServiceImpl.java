package com.baiyun.smartcampus.service.impl;

import com.baiyun.smartcampus.mapper.AdminMapper;
import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.pojo.Teacher;
import com.baiyun.smartcampus.service.AdminService;
import com.baiyun.smartcampus.utils.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : AdminServiceImpl
 * @description: description
 */

@Service
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public Admin login(LoginForm loginForm) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Admin admin = baseMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public Admin getAdminById(Long userId) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>();
        queryWrapper.eq("id",userId);

        return baseMapper.selectOne(queryWrapper);
    }
}
