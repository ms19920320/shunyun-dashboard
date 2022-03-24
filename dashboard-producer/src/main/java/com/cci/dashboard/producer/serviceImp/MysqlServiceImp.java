/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.common.entity.Product;
import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;
import com.cci.dashboard.producer.mapper.ProductMapper;
import com.cci.dashboard.producer.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
    public ResValue getProducts() {
        ResValue resValue = ResValue.defaultSuccess();
        resValue.setContent(productMapper.getProducts());
        return resValue;
    }

    @Override
    public ResValue updateProductById(String id, int number) {
        ResValue resValue = ResValue.defaultSuccess();
        Product product = new Product();
        product.setId(id);
        product.setNumber(number);
        resValue.setContent(productMapper.updateProductById(product));
        return resValue;
    }

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
