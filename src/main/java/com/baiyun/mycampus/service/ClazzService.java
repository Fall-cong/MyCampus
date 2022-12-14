package com.baiyun.mycampus.service;

import com.baiyun.mycampus.pojo.Clazz;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ClazzService extends IService<Clazz> {
    IPage<Clazz> getClazzsByOrp(Page<Clazz> pageParam, Clazz clazz);

    List<Clazz> getClazzs();
}
