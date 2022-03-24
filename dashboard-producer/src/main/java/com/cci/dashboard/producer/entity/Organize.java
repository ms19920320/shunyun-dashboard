/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 组织Dao
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@Data
@TableName("organize")
public class Organize {
    // 组织编号(主键)
    @TableField("organize_id")
    private String organizeId;

    // 组织类型(0-高校 1-研究机构)
    private int type;

    // 名称
    private String name;

    // 地址
    private String address;

    // 电话
    private String tel;

    // 介绍
    private String intro;

    // 官网
    private String web;

    // 省
    private String province;

    // 市
    private String city;

    // 区/县
    private String area;
}
