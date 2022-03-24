/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.cci.dashboard.common.entity.ResValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 全局过滤器
 *
 * @author 孟帅
 * @since 2022/3/17
 */
@Component
public class MyGlobalFilter implements GlobalFilter {
    // 日志处理类
    private static final Logger LOGGER = LoggerFactory.getLogger(MyGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求接口前处理-输出请求参数
        ServerHttpRequest request = exchange.getRequest();
        String hostName = request.getRemoteAddress().getAddress().getHostName();
        String path = request.getPath().toString();
        String methodValue = request.getMethodValue();
        Map<String, String> params = request.getQueryParams().toSingleValueMap();
        LOGGER.info("hostName:{},path:{},methodValue:{},params:{}", hostName, path, methodValue, JSON.toJSONString(params));

        // 请求接口前处理-放过登录接口
        if (path.contains("/dashboard-gateway/login")) {
            return chain.filter(exchange);
        }

        // 请求接口前处理-权限统一认证(这里初步可以采用session + 数据库二级验证,目前不清楚公司整体权限验证方案，还需要进一步了解)
//        HttpHeaders headers = exchange.getRequest().getHeaders();
//        String token = headers.get("token") == null ? null : headers.get("token").get(0);
//        ServerHttpResponse response = exchange.getResponse();
//        if (token == null || !token.equals("123456")) {
//            ResValue resValue = ResValue.unauthorizedError();
//            DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(resValue).getBytes());
//            return exchange.getResponse().writeWith(Mono.just(dataBuffer));
//        }
        Mono<Void> filter = chain.filter(exchange);

        // 请求接口后返回处理
        return filter;
    }
}
