/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.mapper;

import com.cci.dashboard.producer.entity.IndustryPark;

import java.util.List;

/**
 * 产业总览界面DAO
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public interface OverviewMapper {

    List<IndustryPark> getIndustryParks();
}
