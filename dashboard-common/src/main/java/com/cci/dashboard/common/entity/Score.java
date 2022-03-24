/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.common.entity;

import java.io.Serializable;

/**
 * 账户积分表
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public class Score implements Serializable {
    private String id;
    private int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
