/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;
import com.cci.dashboard.producer.mapper.TestMapper;
import com.cci.dashboard.producer.service.OverviewService;
import com.cci.dashboard.producer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单元测试service实现类
 *
 * @author 孟帅
 * @since 2022/3/21
 */
@Service
public class TestServiceImp implements TestService {
    @Autowired(required = false)
    private TestMapper testMapper;

    @Override
    public ResValue addIndustry(Industry industry) {
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue batchAddIndustry(List<Industry> list) {
        testMapper.batchAddIndustry(list);
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue getIndustryIdByName(String name) {
        ResValue resValue = ResValue.defaultSuccess();
        resValue.setContent(testMapper.getIndustryIdByName(name));
        return resValue;
    }

    @Override
    public ResValue batchAddPersonnel(List<Personnel> list) {
        testMapper.batchAddPersonnel(list);
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue updateHierarchy(List<Industry> list) {
        int i = testMapper.updateHierarchy(list);
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue getIndustrys(String hierarchy) {
        List<Industry> industrys = testMapper.getIndustrys(hierarchy);
        for (Industry industry : industrys) {
            industry.setParentId(industry.getIndustryId());
            industry.setHierarchy("04");
        }
        updateHierarchy(industrys);
        return ResValue.defaultSuccess();
    }

}
