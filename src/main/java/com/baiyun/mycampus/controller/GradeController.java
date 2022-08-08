package com.baiyun.mycampus.controller;

import com.baiyun.mycampus.pojo.Grade;
import com.baiyun.mycampus.service.GradeService;
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
 * @className : GradeController
 * @description: description
 */
@Api(tags = "年级控制器")
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @ApiOperation("获取全部年级")
    @GetMapping("/getGrades")
    public Result getGrades() {

        List<Grade> grades = gradeService.getGrades();

        return Result.ok(grades);

    }

    @ApiOperation("删除Grade信息")
    @DeleteMapping("/deleteGrade")
    public Result deleteGrade(@ApiParam("要删除所有的Grade的id的Json集合") @RequestBody List<Integer> ids) {

        gradeService.removeByIds(ids);
        return Result.ok();
    }


    @ApiOperation("新增或修改Grade信息，有id属性是修改，没有则是增加")
    @PostMapping("/saveOrUpdateGrade")
    public Result saveOrUpdateGrade(@ApiParam("Json的Grade对象") @RequestBody Grade grade) {

        //接收参数
        // 调用服务层方法完成增减或则修改
        gradeService.saveOrUpdate(grade);

        return Result.ok();
    }

    @ApiOperation("根据年纪名称模糊查询带分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGrades(@ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
                            @ApiParam("分页查询页的大小") @PathVariable("pageSize") Integer pageSize,
                            @ApiParam("分页查询模糊匹配") String gradeName) {

        // 分页 带条件查询
        Page<Grade> page = new Page<>(pageNo, pageSize);
        // 通过服务层
        IPage<Grade> pageRs = gradeService.getGtadeByOpr(page, gradeName);

        return Result.ok(pageRs);
    }
}
