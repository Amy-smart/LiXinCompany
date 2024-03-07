package com.atlixin.yygh;

import com.atlixin.yygh.service.DictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceCmnApplicationTests {
//    @Test
//    void contextLoads() {
//    }
    @Autowired
    DictService dictService;

//    @Test
//    public void test() {
//        System.out.println(dictService.selectChild(86L));
//    }
}
