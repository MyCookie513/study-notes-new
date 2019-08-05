package com.jason.controller;

import com.jason.client.UserClient;
import com.jason.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.security.jca.ServiceId;

import java.util.List;

@RestController
/*
@DefaultProperties(defaultFallback = "defaultFallback")
*/
public class UserCalled {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient Client;
   /* @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private UserClient userClient;
    @GetMapping("getUser")
   /* @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "10000")
            }
    )*/
    public String getUserFromOtherService(){
        /***********没有负载均衡的获取instance的方式***************************************************/
        //服务id： 指的是一种类型的服务
        //服务的实例： 有多个多台主机在跑同一个服务，每一个主机就是一个实例
        //根据服务的id获取服务的实例
       /* List<ServiceInstance> services=discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance=services.get(0);

        System.out.println(serviceInstance.getHost());
        return restTemplate.getForObject("http://" +
                serviceInstance.getHost()+":"+
                serviceInstance.getPort()+
                "/User/1",User.class);*/

        /*************************************************************/


        /***********带有负载均衡的实现方式,比较复杂的实现方式**************************************************/

          /*  ServiceInstance serviceInstance=Client.choose("user-service");
            System.out.println(serviceInstance.getHost());
            return restTemplate.getForObject("http://" +
                    serviceInstance.getHost()+":"+
                    serviceInstance.getPort()+
                    "/User/1",User.class);*/
        /*************************************************************/

        /**********************常用的实现方式************************/
         /*   return restTemplate.getForObject("http://"
                    + "user-service"
                    + "/User/1",User.class).toString();*/
        /**********************常用的实现方式************************/


        /**********************利用feign框架的实现方式************************/
       /* 1.自动调用Ribbon负载均衡*/
      /*  2.自动调用rest风格的接口*/

        return userClient.queryuser(Long.valueOf(1)).toString();
        /*******************************************************************/

    }


    public String defaultFallback(){

        return "用户信息查询出现异常！";
    }
}
