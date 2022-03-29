/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.IndustryPark;
import com.cci.dashboard.producer.mapper.OverviewMapper;
import com.cci.dashboard.producer.service.OverviewService;
import com.cci.dashboard.producer.type.Hierarchy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public ResValue industryStatistics(Map<String, Object> params) {
        JSONObject content = new JSONObject();
        List<Industry> industry01s = overviewMapper.getIndustryByHierarchy(Hierarchy.O1.getHierarchy());
        if (!industry01s.isEmpty()) {
            content.put("name", industry01s.get(0).getName());
            content.put("industryId", industry01s.get(0).getIndustryId());
        }
        JSONArray detail01 = new JSONArray();
        content.put("detail", detail01);

        List<Industry> industry02s = overviewMapper.getIndustryByHierarchy(Hierarchy.O2.getHierarchy());
        for (Industry industry02 : industry02s) {
            JSONArray detail02 = new JSONArray();
            JSONObject map02 = new JSONObject();
            map02.put("name", industry02.getName());
            map02.put("industryId", industry02.getIndustryId());
            map02.put("total", 22);
            map02.put("position", industry02.getPosition());
            map02.put("detail", detail02);
            detail01.add(map02);

            List<Industry> industry03s = overviewMapper.getIndustryByParentId(industry02.getIndustryId());
            for (Industry industry03 : industry03s) {
                JSONArray detail03 = new JSONArray();
                JSONObject map03 = new JSONObject();
                map03.put("name", industry03.getName());
                map03.put("industryId", industry03.getIndustryId());
                map03.put("total", 22);
                map03.put("detail", detail03);
                detail02.add(map03);

                List<Industry> industry04s = overviewMapper.getIndustryByParentId(industry03.getIndustryId());
                for (Industry industry04 : industry04s) {
                    JSONObject map04 = new JSONObject();
                    map04.put("industryId", industry04.getIndustryId());
                    map04.put("name", industry04.getName());
                    params.put("industryId", industry04.getIndustryId());
                    Map<String, Object> res = overviewMapper.industryStatistics(params);
                    map04.put("total", res.get("total"));
                    detail03.add(map04);
                }
                System.out.println("aa");
            }
            System.out.println("bb");
        }
        ResValue resValue = ResValue.defaultSuccess();
        resValue.setContent(content);
        return resValue;
    }


}
