/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 产业园Dao
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@Data
@TableName("industrial_park")
public class IndustryPark {
    // 主键自增长
    private int id;

    // 名称
    private String name;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

}
