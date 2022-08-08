package com.baiyun.mycampus.controller;

import com.baiyun.mycampus.pojo.Admin;
import com.baiyun.mycampus.service.AdminService;
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
 * @className : AdminController
 * @description: description
 */

@Api(tags = "管理员控制器")
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("分页带查询管理员信息")
    @GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
    public Result getAllAdmin(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                              @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
                              @ApiParam("管理员名字") String adminName
    ) {


        Page<Admin> pageParam = new Page<Admin>(pageNo, pageSize);
        IPage<Admin> iPage = adminService.getAdminsByOrp(pageParam, adminName);

        return Result.ok(iPage);
    }

    @ApiOperation("增加或修改管理员信息")
    @PostMapping("/saveOrUpdateAdmin")
    public Result saveOrUpdateAdmin(@ApiParam("JAON格式的Admin对象") @RequestBody Admin admin) {

        Integer id = admin.getId();
        if (id == null || 0 == id) {
            admin.setPassword(MD5.encrypt(admin.getPassword()));
        }
        adminService.saveOrUpdate(admin);

        return Result.ok();
    }

    @ApiOperation("删除单个或多个管理员信息")
    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(@ApiParam("要删除的管理员的多个id的JSON集合") @RequestBody List<Integer> ids) {

        adminService.removeByIds(ids);

        return Result.ok();
    }


}
