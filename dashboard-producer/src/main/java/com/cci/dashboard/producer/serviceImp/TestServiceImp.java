package com.cci.dashboard.producer.serviceImp;

import com.cci.dashboard.producer.service.TestApi;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp implements TestApi {
    @Override
    public String test1() {
        return "test1";
    }

    @Override
    public String test2() {
        return "test2";
    }
}
