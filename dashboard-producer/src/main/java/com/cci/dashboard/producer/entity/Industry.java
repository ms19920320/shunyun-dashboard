/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
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
}
