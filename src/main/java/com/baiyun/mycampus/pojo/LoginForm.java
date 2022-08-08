package com.baiyun.mycampus.pojo;

import lombok.Data;

/**
 * @author : fall
 * @date : 2022-08-06 18:24
 * @className : LoginForm
 * @description: description
 */

@Data
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
