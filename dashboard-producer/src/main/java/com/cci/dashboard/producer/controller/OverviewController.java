package com.cci.dashboard.producer.controller;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产业总览模块入口
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@RestController
@RequestMapping(value = "overview")
public class OverviewController {
    @Autowired(required = false)
    private OverviewService overviewService;

    @GetMapping("/getIndustryParks")
    public ResValue getIndustryParks() {
        return overviewService.getIndustryParks();
    }

    @GetMapping("/companyStatistics")
    public ResValue companyStatistics() {
        return overviewService.companyStatistics();
    }
}
