package com.baiyun.mycampus.controller;

import com.baiyun.mycampus.pojo.Clazz;
import com.baiyun.mycampus.service.ClazzService;
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
 * @className : ClazzController
 * @description: description
 */
@Api(tags = "班级控制器")
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @ApiOperation("查询所有班级信息")
    @GetMapping("/getClazzs")
    public Result getClazzs() {
        List<Clazz> clazzes = clazzService.getClazzs();

        return Result.ok(clazzes);
    }


    @ApiOperation("根据id删除单个或多个班级的信息")
    @DeleteMapping("/deleteClazz")
    public Result deleteClazz(@ApiParam("要删除的多个班级的id的JSON数组") @RequestBody List<Integer> ids) {

        clazzService.removeByIds(ids);
        return Result.ok();
    }


    @ApiOperation("新增或修改班级信息")
    @PostMapping("/saveOrUpdateClazz")
    public Result saveOrUpdateClazz(@ApiParam("Json格式的班级信息") @RequestBody Clazz clazz) {

        //接收参数
        // 调用服务层方法完成增减或则修改
        clazzService.saveOrUpdate(clazz);

        return Result.ok();
    }


    @ApiOperation("分页带条件查询班级信息")
    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result getClazzByOpr(@ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
                                @ApiParam("分页查询页的大小") @PathVariable("pageSize") Integer pageSize,
                                @ApiParam("分页查询的查询条件") Clazz clazz) {

        Page<Clazz> page = new Page<>(pageNo, pageSize);
        IPage<Clazz> iPage = clazzService.getClazzsByOrp(page, clazz);

        return Result.ok(iPage);
    }

}
