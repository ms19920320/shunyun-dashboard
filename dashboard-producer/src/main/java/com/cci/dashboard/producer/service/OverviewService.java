/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.service;

import com.cci.dashboard.common.entity.ResValue;

import java.util.Map;

/**
 * 产业总览界面service
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public interface OverviewService {

    /**
     * 获取产业园列表
     *
     * @return .
     */
    ResValue getIndustryParks();

    /**
     * 获取全国总企业数量及各省企业数量
     *
     * @return .
     */
    ResValue companyStatistics();

    /**
     * 获取产业分布统计
     *
     * @return .
     */
    ResValue industryStatistics(Map<String, Object> params);

}
