/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.IndustryPark;
import com.cci.dashboard.producer.mapper.OverviewMapper;
import com.cci.dashboard.producer.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产业总览界面service实现类
 *
 * @author 孟帅
 * @since 2022/3/21
 */
@Service
public class OverviewServiceImp implements OverviewService {
    @Autowired(required = false)
    private OverviewMapper overviewMapper;

    @Override
    public ResValue getIndustryParks() {
        List<IndustryPark> industryParks = overviewMapper.getIndustryParks();
        ResValue resValue = ResValue.defaultSuccess();
        resValue.setContent(industryParks);
        return resValue;
    }
}
