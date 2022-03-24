package com.cci.dashboard.monitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author 孟帅
 * @since 2022/3/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
    @Test
    public void getUUID() {
        for (int i = 0; i < 10; i++) {
            System.out.println("uuid is " + UUID.randomUUID());
        }
    }
}
