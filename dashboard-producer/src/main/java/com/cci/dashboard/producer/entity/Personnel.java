/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 人才表DAO
 *
 * @author 孟帅
 * @since 2022/3/23
 */
@Data
@TableName("personnel")
public class Personnel {
    // 主键
    @TableField("personnel_id")
    private String personnelId;

    // 姓名
    private String name;

    // 介绍
    private String intro;

    // 从事领域
    private String field;

    // 领域相关
    private String relation;
}
