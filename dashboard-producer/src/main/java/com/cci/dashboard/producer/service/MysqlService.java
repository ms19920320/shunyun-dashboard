/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.service;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;

import java.util.List;

/**
 * 接口服务定义
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public interface MysqlService {
    ResValue getProducts();

    ResValue updateProductById(String id, int number);

    ResValue addIndustry(Industry industry);

    ResValue batchAddIndustry(List<Industry> list);

    ResValue getIndustryIdByName(String name);

    ResValue batchAddPersonnel(List<Personnel> list);
}
