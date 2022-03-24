/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.mapper;

import com.cci.dashboard.common.entity.Product;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;
import net.sf.jsqlparser.statement.create.table.Index;

import java.util.List;

/**
 * 产品dao
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public interface ProductMapper {
    List<Product> getProducts();

    int updateProductById(Product product);

    int addIndustry(Industry industry);

    int batchAddIndustry(List<Industry> list);

    String getIndustryIdByName(String name);

    int batchAddPersonnel(List<Personnel> list);
}
