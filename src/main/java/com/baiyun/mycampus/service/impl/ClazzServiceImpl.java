package com.baiyun.mycampus.service.impl;

import com.baiyun.mycampus.mapper.ClazzMapper;
import com.baiyun.mycampus.pojo.Clazz;
import com.baiyun.mycampus.service.ClazzService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author : fall
 * @date : 2022-08-06 18:31
 * @className : ClazzServiceImpl
 * @description: description
 */

@Service
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

    @Override
    public IPage<Clazz> getClazzsByOrp(Page<Clazz> pageParam, Clazz clazz) {

        QueryWrapper<Clazz> queryWrapper = new QueryWrapper<>();
        String gradeName = clazz.getGradeName();
        if (!StringUtils.isEmpty(gradeName)) {
            queryWrapper.like("grade_name", gradeName);
        }
        String name = clazz.getName();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        queryWrapper.orderByDesc("id");

        Page<Clazz> clazzPage = baseMapper.selectPage(pageParam, queryWrapper);

        return clazzPage;
    }

    @Override
    public List<Clazz> getClazzs() {

        return baseMapper.selectList(null);

    }
}