/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 产品类
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private int number;
    private int score;
    private Timestamp updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
