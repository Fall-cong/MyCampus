package com.baiyun.smartcampus.service.impl;

import com.baiyun.smartcampus.mapper.AdminMapper;
import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.service.AdminService;
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

}
