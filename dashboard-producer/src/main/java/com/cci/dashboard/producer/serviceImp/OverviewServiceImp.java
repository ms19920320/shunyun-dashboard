/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.IndustryPark;
import com.cci.dashboard.producer.mapper.OverviewMapper;
import com.cci.dashboard.producer.service.OverviewService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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

    @Override
    public ResValue companyStatistics() {
        ResValue resValue;

        // 获取产业园统计
        List<IndustryPark> industryParks = overviewMapper.getIndustryParks();

        // 获取公司分布统计
        List<Map<String, Object>> objects = overviewMapper.companyStatistics();
        int sum = objects.stream().flatMapToInt(p -> IntStream.of(Integer.valueOf(String.valueOf(p.get("sub"))))).sum();
        Map<String, Object> industryParksMap = new HashMap<>();
        Map<String, Object> companyMap = new HashMap<>();

        // 封装返回content内容
        Map<String, Object> content = new HashMap<>();
        industryParksMap.put("total", industryParks.size());
        industryParksMap.put("detail", industryParks);
        companyMap.put("total", sum);
        companyMap.put("detail", objects);
        content.put("industryPark", industryParksMap);
        content.put("company", companyMap);
        resValue = ResValue.defaultSuccess();
        resValue.setContent(content);
        return resValue;
    }
}
