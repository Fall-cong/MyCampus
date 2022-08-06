package com.baiyun.smartcampus.service.impl;

import com.baiyun.smartcampus.mapper.GradeMapper;
import com.baiyun.smartcampus.pojo.Clazz;
import com.baiyun.smartcampus.pojo.Grade;
import com.baiyun.smartcampus.service.ClazzService;
import com.baiyun.smartcampus.service.GradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : GradeServiceImpl
 * @description: description
 */

@Service
@Transactional
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

}
