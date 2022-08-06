package com.baiyun.smartcampus.service.impl;


import com.baiyun.smartcampus.mapper.StudentMapper;

import com.baiyun.smartcampus.pojo.Student;
import com.baiyun.smartcampus.service.StudentService;
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

}
