/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产业链Dao
 *
 * @author 孟帅
 * @since 2022/3/23
 */
@Data
@TableName("industry")
public class Industry {
    // 产业id(主键)
    @TableField("industry_id")
    private String industryId;

    // 名称
    private String name;

    // 父级产业id
    @TableField("parent_id")
    private String parentId;

    // 层级 01-电机产业链 02-xx 03-xx 04-xx
    private String hierarchy;

    // 位置 01-电机产业链 02-上游 03-中游 04-下游
    private String position;
}
