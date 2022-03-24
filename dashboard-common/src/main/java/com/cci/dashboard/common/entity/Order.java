/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 订单表
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public class Order implements Serializable {
    private String id;
    private String account;
    private String info;
    private Timestamp time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
