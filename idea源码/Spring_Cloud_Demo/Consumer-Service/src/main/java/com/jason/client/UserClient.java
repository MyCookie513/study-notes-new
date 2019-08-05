package com.jason.client;


import com.jason.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "user-service",fallback = UserClientImpl.class)
public interface UserClient {

@GetMapping("User/{id}")
    User queryuser(@PathVariable("id") Long id);

}