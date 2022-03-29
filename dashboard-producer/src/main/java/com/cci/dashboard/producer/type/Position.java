/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.type;

/**
 * 用来表示产业位置的枚举类
 *
 * @author 孟帅
 * @since 2022/3/29
 */
public enum Position {
    // 产业处于上游位置
    UP("01"),

    // 产业处于中游位置
    MIDDLE("02"),

    // 产业处于下游位置
    BELOW("03");

    private String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
