package com.leyou.user.web;

import com.leyou.user.pojo.User;
import com.leyou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @author bystander
 * @date 2018/9/29
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验数据
     * @param data
     * @param type
     * @return
     */
    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> checkData(@PathVariable("data") String data, @PathVariable("type") Integer type) {
        return ResponseEntity.ok(userService.checkData(data, type));
    }

    /**
     * 发送验证码     完成；
     * @param phone
     * @return
     */
    @PostMapping("send")
    public ResponseEntity<Void> sendVerifyCode(@RequestParam("phone")String phone) {
        userService.sendVerifyCode(phone);
        return ResponseEntity.noContent().build();
    }


    /**
     *
     * @param user  valid :这个是属于Bean校验的注解，这个是表示： 被注释的元素是一个对象，需要检查此对象的所有字段值；
     * @param result :如果加上这个参数BindingResult 后，无论user的格式是否校验成功，都将会进入这个方法执行；
     * @param code
     * @return
     */
    @PostMapping("register")
    public ResponseEntity<Void> register(@Valid User user, BindingResult result, @RequestParam("code")String code) {
        if (result.hasFieldErrors()){
            throw new RuntimeException(result.getAllErrors().stream().map(e ->e.getDefaultMessage()).collect(Collectors.joining("|")));
        }
        userService.register(user, code);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("query")
    public ResponseEntity<User> queryUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.queryUser(username, password));
    }


}
