/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.service;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.IndustryPark;

import java.util.List;

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
     * @return 产业园列表集合
     */
    ResValue getIndustryParks();

    /**
     * 获取全国总企业数量及各省企业数量
     */
    ResValue companyStatistics();
}
