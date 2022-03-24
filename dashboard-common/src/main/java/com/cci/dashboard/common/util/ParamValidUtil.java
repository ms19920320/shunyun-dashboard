/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.common.util;

import java.util.List;
import java.util.Map;

/**
 * 参数非空校验
 *
 * @author 孟帅
 * @since 2022/3/21
 */
public class ParamValidUtil {
    /**
     * 校验参数是否为null
     *
     * @param params    接口入参集合
     * @param paramNames 参数键名列表
     * @return boolean
     * @author 孟帅
     * @since 2022/3/21
     */
    public static boolean isValid(Map<String, Object> params, String... paramNames) {
        if (params == null || params.isEmpty()) {
            return false;
        }
        for (String paramName : paramNames) {
            if (paramName == null || params.get(paramName) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验参数是否为null
     *
     * @param params    接口入参集合
     * @param paramName 集合参数键名称
     * @return boolean
     * @author 孟帅
     * @since 2022/3/21
     */
    public static boolean isValid(Map<String, Object> params, String paramName) {
        if (params == null) {
            return false;
        }
        return paramName != null && params.get(paramName) != null;
    }

    /**
     * 校验参数是否为null
     *
     * @param params     接口入参集合
     * @param paramNames 集合参数键名称集合
     * @return boolean
     * @author 孟帅
     * @since 2022/3/21
     */
    public static boolean isValid(Map<String, Object> params, List<String> paramNames) {
        if (params == null) {
            return false;
        }
        if (paramNames == null || paramNames.isEmpty()) {
            return false;
        }
        for (String paramName : paramNames) {
            if (params.get(paramName) == null) {
                return false;
            }
        }
        return true;
    }
}
