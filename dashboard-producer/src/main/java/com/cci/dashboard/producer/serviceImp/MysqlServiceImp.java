/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;
import com.cci.dashboard.producer.mapper.ProductMapper;
import com.cci.dashboard.producer.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service 实现类
 *
 * @author 孟帅
 * @since 2022/3/21
 */
@Service
public class MysqlServiceImp implements MysqlService {
    @Autowired(required = false)
    private ProductMapper productMapper;

    @Override
    public ResValue addIndustry(Industry industry) {
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue batchAddIndustry(List<Industry> list) {
        productMapper.batchAddIndustry(list);
        return ResValue.defaultSuccess();
    }

    @Override
    public ResValue getIndustryIdByName(String name) {
        ResValue resValue = ResValue.defaultSuccess();
        resValue.setContent(productMapper.getIndustryIdByName(name));
        return resValue;
    }

    @Override
    public ResValue batchAddPersonnel(List<Personnel> list) {
        productMapper.batchAddPersonnel(list);
        return ResValue.defaultSuccess();
    }
}
