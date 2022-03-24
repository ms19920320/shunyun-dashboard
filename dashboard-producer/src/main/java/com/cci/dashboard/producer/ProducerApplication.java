package com.cci.dashboard.producer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.cci.dashboard.producer.mapper")
public class ProducerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProducerApplication.class).run(args);
    }
}
