package com.baiyun.mycampus.controller;


import com.baiyun.mycampus.pojo.Teacher;
import com.baiyun.mycampus.service.TeacherService;
import com.baiyun.mycampus.utils.MD5;
import com.baiyun.mycampus.utils.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : fall
 * @date : 2022-08-06 18:41
 * @className : TeacherController
 * @description: description
 */

@Api(tags = "教师管理器")
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("删除单个或多个老师信息")
    @DeleteMapping("/deleteTeacher")
    public Result delTeacherById(@ApiParam("要删除的老师编号的JSON数组") @RequestBody List<Integer> ids) {

        teacherService.removeByIds(ids);
        return Result.ok();
    }


    @ApiOperation("老师信息添加或修改")
    @PostMapping("/saveOrUpdateTeacher")
    public Result saveOrUpdateTeacher(@ApiParam("要保存或修改老师的JSON") @RequestBody Teacher teacher) {

        Integer id = teacher.getId();
        if (null == id || 0 == id) {
            teacher.setPassword(MD5.encrypt(teacher.getPassword()));
        }

        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }


    @ApiOperation("分页带条件查询老师信息")
    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result getTeachers(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                                  @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
                                  @ApiParam("查询条件") Teacher teacher) {
        // 分页信息封装Page对象
        Page<Teacher> pageParam = new Page<>(pageNo, pageSize);
        // 进行查询
        IPage<Teacher> teacherIPage = teacherService.getTeacherByOpr(pageParam, teacher);
        // 封装Result返回
        return Result.ok(teacherIPage);
    }
}
