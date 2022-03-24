/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer.entity;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 孟帅
 * @since 2022/3/24
 */
@Configuration
public class Person {
    public Person() {
        System.out.println("person======");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory======");
    }

    @PostConstruct
    public void create() {
        System.out.println("create======");
    }
}
