package com.leyou.sms.listener;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bystander
 * @date 2018/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsListenerTest {


    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 作为一个生产者去向sms服务队列中发送消息
     * @throws InterruptedException
     */
    @Test
    public void listenVerifyCode() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        map.put("phone", "15519486860");
        map.put("code", "520");
        amqpTemplate.convertAndSend("ly.sms.exchange", "sms.verify.code", map);
        Thread.sleep(5000);
    }
}