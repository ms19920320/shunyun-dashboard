/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.controller;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * mysql数据访问类
 *
 * @author 孟帅
 * @since 2022/3/21
 */
@RestController
@RequestMapping(value = "mysql")
public class MysqlController {

    @Autowired
    private MysqlService mysqlService;

    @GetMapping(value = "getProducts")
    public ResValue getProducts() {
        return mysqlService.getProducts();
    }

    @PostMapping(value = "updateProductById")
    public ResValue updateProductById(@RequestParam String id, @RequestParam int number) {
        return mysqlService.updateProductById(id, number);
    }
}
