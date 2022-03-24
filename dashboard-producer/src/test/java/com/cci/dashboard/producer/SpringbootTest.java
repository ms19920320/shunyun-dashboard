/*
 *  城云科技 ©1997-2022
 */

package com.cci.dashboard.producer;

import com.cci.dashboard.common.entity.ResValue;
import com.cci.dashboard.producer.entity.Industry;
import com.cci.dashboard.producer.entity.Personnel;
import com.cci.dashboard.producer.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author 孟帅
 * @since 2022/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
    @Autowired(required = false)
    private TestService testService;

    @org.junit.Test
    public void getUuid() {
        for (int i = 0; i < 20; i++) {
            System.out.println(UUID.randomUUID());
        }
    }

    @org.junit.Test
    public void batchAddIndustry() {
        ResValue resValue = testService.getIndustryIdByName("核电");
        String id = resValue.getContent().toString();
        List<String> a1 = Arrays.asList("通水", "通风");
        System.out.println("aabbcc" + a1.size());
        List<Industry> params = new ArrayList<>();
        for (int i = 0; i < a1.size(); i++) {
            Industry industry = new Industry();
            industry.setId(UUID.randomUUID().toString());
            industry.setName(a1.get(i));
            industry.setParentId(id);
            params.add(industry);
        }
        testService.batchAddIndustry(params);
    }

    @org.junit.Test
    public void batchAddPersonnel() {
        List<Personnel> list = new ArrayList<>();
        List<String> a = Arrays.asList("吴耀华", "阮耀钟", "夏维东", "冯志华", "尚伟伟", "董小鹏", "孔凡让", "丛爽",
                "裴刚", "陈则韶", "季杰");
        for (int i = 0; i < a.size(); i++) {
            Personnel personnel = new Personnel();
            personnel.setId(UUID.randomUUID().toString());
            personnel.setIntro("");
            personnel.setName(a.get(i));
            list.add(personnel);
        }
        testService.batchAddPersonnel(list);
    }
}
