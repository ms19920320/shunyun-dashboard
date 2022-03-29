/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.type;

/**
 * 用来表示当前产业类型所属的层级枚举类
 *
 * @author 孟帅
 * @since 2022/3/29
 */
public enum Hierarchy {
    // 第一层级-电机产业链
    O1("01"),

    // 第二层级-电机应用设备，电机原材料，电机零部件，电机集成
    O2("02"),

    // 第三层级-xx
    O3("03"),

    // 第四层级-xx
    O4("04");

    private String hierarchy;

    Hierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getHierarchy() {
        return hierarchy;
    }
}
