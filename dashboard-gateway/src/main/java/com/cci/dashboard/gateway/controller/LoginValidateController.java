/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.gateway.controller;

import com.cci.dashboard.common.entity.ResValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 *
 * @author 孟帅
 * @since 2022/3/18
 */
@RestController
public class LoginValidateController {

    @PostMapping
    @RequestMapping(value = "/login")
    public ResValue login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("zs") && password.equals("123456")) {
            ResValue resValue = ResValue.defaultSuccess();
            // 从后台获取token值，封装到请求头中，后续的请求便可以直接通过token验证
            resValue.setContent("123456");
            return resValue;
        }
        return ResValue.unauthorizedError();
    }
}
