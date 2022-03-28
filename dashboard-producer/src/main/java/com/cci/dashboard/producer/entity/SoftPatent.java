/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 专利/软著DAO
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@Data
@TableName("soft_patent")
public class SoftPatent {
    // 软著编号(主键)
    @TableField("soft_patent_id")
    private String softPatentId;

    // 名称
    private String name;

    // 类型(0-专利 1-软著)
    private int type;

    // 专利/软著号
    private String code;

    // 日期
    private Timestamp date;
}
