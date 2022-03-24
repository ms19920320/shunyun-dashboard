/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.gateway.controller;

import com.cci.dashboard.common.entity.ResValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "test")
    public ResValue test() {
        redisTemplate.opsForValue().set("lisi" + new Random().nextInt(100), "haoren");
        return ResValue.defaultSuccess();
    }
}
