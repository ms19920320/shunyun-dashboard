/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.gateway;

import com.cci.dashboard.common.entity.ResValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 服务降级回调地址
     *
     * @return 服务熔断码和提示
     * @author 孟帅
     * @since 2022/3/17
     */
    @GetMapping(value = "fuse")
    public ResValue fuse() {
        return ResValue.fuseError();
    }
}
