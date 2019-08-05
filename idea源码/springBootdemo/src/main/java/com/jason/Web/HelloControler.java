package com.jason.Web;

import com.jason.Config.yaml_Inject;
import com.jason.Service.UserService;
import com.jason.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("user")  /* 请求地址的映射  */
@RestController          /* 可返回一段字符串*/
@Slf4j
public class HelloControler {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User hello(@PathVariable("id") Long id){

        return userService.QueryById(id);
    }



}
