package com.baiyun.smartcampus.service.impl;


import com.baiyun.smartcampus.mapper.TeacherMapper;
import com.baiyun.smartcampus.pojo.Teacher;
import com.baiyun.smartcampus.service.TeacherService;
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

}
