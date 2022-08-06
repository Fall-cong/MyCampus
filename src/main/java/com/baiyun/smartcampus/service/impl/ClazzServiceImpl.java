package com.baiyun.smartcampus.service.impl;

import com.baiyun.smartcampus.mapper.ClazzMapper;
import com.baiyun.smartcampus.pojo.Clazz;
import com.baiyun.smartcampus.service.ClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : ClazzServiceImpl
 * @description: description
 */

@Service
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

}
