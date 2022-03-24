package com.cci.dashboard.producer.controller;


import com.cci.dashboard.common.entity.ResValue;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${dashboard-producer1-name}")
    private String dashboardProducer1Name;

    @Value("${dashboard-gateway-name}")
    private String gatewayName;

    /**
     * 微服务之间直接调用
     *
     * @return .
     */
    @GetMapping(value = "test")
    public ResValue test() {
        LOGGER.info("enter the producer test method");
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(dashboardProducer1Name, false);
        String homePageUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(homePageUrl + dashboardProducer1Name + "/service/test/test", ResValue.class);
    }

    /**
     * 微服务之间直接调用
     *
     * @return .
     */
    @PostMapping(value = "/test1")
    public ResValue test1(@RequestParam String name, @RequestParam int age) {
        LOGGER.info("enter the producer test1 method");
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(dashboardProducer1Name, false);
        String url = nextServerFromEureka.getHomePageUrl() + dashboardProducer1Name + "/service/test/test1";
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("name", name);
        postParameters.add("age", age);
        return restTemplate.postForObject(url, postParameters, ResValue.class);
    }

    /**
     * 微服务之间直接调用
     *
     * @return .
     */
    @PostMapping(value = "/test2")
    public ResValue test2(@RequestBody Map<String, Object> param) {
        LOGGER.info("enter the producer test2 method");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(dashboardProducer1Name, false);
        String url = nextServerFromEureka.getHomePageUrl() + dashboardProducer1Name + "/service/test/test2";
        return restTemplate.postForObject(url, param, ResValue.class);
    }

}
