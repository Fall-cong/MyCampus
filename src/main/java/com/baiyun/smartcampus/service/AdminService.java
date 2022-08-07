package com.baiyun.smartcampus.service;

import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminService extends IService<Admin> {
    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);
}
