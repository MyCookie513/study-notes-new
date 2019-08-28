package com.leyou.feignClient;

import com.leyou.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class GoodsClientTest {

    @Autowired
    private GoodsClient categoryClient;

    @Test
    public void testQueryCategories() {
        List<String> categoryList =this.categoryClient.queryNameByIds(Arrays.asList(1L, 2L, 3L)).getBody();
        for (String category : categoryList) {
            System.out.println("category = " + category);
        }
    }
}
