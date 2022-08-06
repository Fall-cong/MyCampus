package com.baiyun.smartcampus.controller;

import com.baiyun.smartcampus.pojo.Admin;
import com.baiyun.smartcampus.pojo.Clazz;
import com.baiyun.smartcampus.pojo.LoginForm;
import com.baiyun.smartcampus.service.AdminService;
import com.baiyun.smartcampus.utils.CreateVerifiCodeImage;
import com.baiyun.smartcampus.utils.JwtHelper;
import com.baiyun.smartcampus.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : fall
 * @date : 2022-08-06 18:45
 * @className : SysController
 * @description: description
 */

@RestController
@RequestMapping("/sms/system")
public class SystemController {

    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        // 验证码校验
        HttpSession session = request.getSession();
        String sessionVerifiCode = (String) session.getAttribute("verifiCode");
        String loginVerifiCode = loginForm.getVerifiCode();
        if ("".equals(sessionVerifiCode) || null == sessionVerifiCode) {
            return Result.fail().message("验证码失效，请刷新后重试");
        }
        if (sessionVerifiCode.equalsIgnoreCase(loginVerifiCode)) {
            return Result.fail().message("验证码有误，请小心输入后重试");
        }
        // 从session域中移除现有验证码
        session.removeAttribute("verifiCode");

        // 准备一个map存放用户响应的数据
        Map<String, Object> map = new LinkedHashMap<>();



        //分用户类型校验
        switch (loginForm.getUserType()) {
            case 1:
                try {
                    Admin admin = adminService.login(loginForm);
                    if (null != admin) {
                        // 用户类型和用户id转换成一个密文，以token的名称向客户端反馈
                        map.put("token", JwtHelper.createToken(admin.getId().longValue(), 1));
                    } else {
                        throw new RuntimeException("用户名或密码有误")
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }

            case 2:
            case 3:
        }
        return Result.fail().message("查无此用户");
    }


    @GetMapping("/getVerifiCodeImage")
    public void getVerfiCodeImage(HttpServletRequest request, HttpServletResponse response) {

        //获取图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();

        // 获取图片上的验证码
        String verifiCode = new String(CreateVerifiCodeImage.getVerifiCode());

        // 将验证码文本放入session域中，为下一次验证做准备
        HttpSession session = request.getSession();
        session.setAttribute("verfiCode", verifiCode);

        // 将验证码图片响应给浏览器
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
