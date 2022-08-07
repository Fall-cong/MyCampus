package com.baiyun.smartcampus.service;

import com.baiyun.smartcampus.pojo.Clazz;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ClazzService extends IService<Clazz> {
    IPage<Clazz> getClazzsByOrp(Page<Clazz> pageParam, Clazz clazz);
}
