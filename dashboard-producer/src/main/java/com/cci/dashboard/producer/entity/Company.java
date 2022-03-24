/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 公司表Dao
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@Data
@TableName("company")
public class Company {
    // 主键
    @TableField("company_id")
    private String companyId;

    // 中文名称
    @TableField("cn_name")
    private String cnName;

    // 英文名称
    @TableField("en_name")
    private String enName;

    // 注册时间
    @TableField("register_time")
    private Timestamp registerTime;

    // 经营状态
    @TableField("business_status")
    private String businessStatus;

    // 经营范围
    @TableField("business_scope")
    private String businessScope;

    // 经营期限
    @TableField("business_period")
    private String businessPeriod;

    // 所属区域
    @TableField("belong_area")
    private String belongArea;

    // 注册资金
    private String capital;

    // 实缴资金
    @TableField("paid_in_capital")
    private String paidInCapital;

    // 人员规模
    @TableField("personnel_scale")
    private String personnelScale;

    // 法定代表人
    @TableField("legal_represent")
    private String legalRepresent;

    // 地址
    private String address;

    // 统一社会新用代码
    @TableField("new_code")
    private String newCode;

    // 企业类型
    private String type;

    // 核准日期
    @TableField("approval_date")
    private Timestamp approvalDate;

    // 建立日期
    @TableField("establish_date")
    private Timestamp establishDate;

    // 参保人数
    @TableField("insured_persons")
    private String insuredPersons;

    // 所属行业
    private String industry;

    // 纳税人识别号
    private String tid;

    // 注册机构
    @TableField("register_authority")
    private String registerAuthority;

    // 组织机构代码
    @TableField("organize_code")
    private String organizeCode;

    // 股权结构
    @TableField("ownership_structure")
    private String ownershipStructure;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 产品
    private String product;

}
