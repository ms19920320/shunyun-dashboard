/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer;

import com.cci.dashboard.producer.service.OverviewService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 接口单元测试
 *
 * @author 孟帅
 * @since 2022/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired(required = false)
    private OverviewService overviewService;

    @org.junit.Test
    public void companyStatistics() {
        overviewService.companyStatistics();
    }
}
