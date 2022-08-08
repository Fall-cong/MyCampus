package com.baiyun.mycampus.service;

import com.baiyun.mycampus.pojo.Admin;
import com.baiyun.mycampus.pojo.LoginForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminService extends IService<Admin> {
    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);

    IPage<Admin> getAdminsByOrp(Page<Admin> pageParam, String adminName);
}
