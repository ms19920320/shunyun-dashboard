/*
 * 城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.config;

import com.cci.dashboard.common.entity.ResValue;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author 孟帅
 * @since 2022/3/24
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResValue exceptionHandler(Exception e) {
        ResValue resValue = ResValue.internalError();
        resValue.setContent(e.getMessage());
        return resValue;
    }
}
