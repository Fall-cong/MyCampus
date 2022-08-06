package com.baiyun.smartcampus.mapper;

import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
