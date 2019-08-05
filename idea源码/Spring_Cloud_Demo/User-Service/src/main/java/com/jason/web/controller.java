package com.jason.web;

import com.jason.pojo.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("User")
public class controller {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
           // e.printStackTrace();
        }

        return userService.getUser(id);
    }

}
