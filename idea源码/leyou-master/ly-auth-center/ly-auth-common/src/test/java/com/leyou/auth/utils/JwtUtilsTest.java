package com.leyou.auth.utils;


import com.leyou.auth.entity.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author bystander
 * @date 2018/10/1
 */
public class JwtUtilsTest {

    private static final String publicKeyPath = "/Users/bystander/rsa.pub";
    private static final String privateKeyPath = "/Users/bystander/rsa.pri";

    private PrivateKey privateKey;
    private PublicKey publicKey;


    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(publicKeyPath, privateKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        publicKey = RsaUtils.getPublicKey(publicKeyPath);
    }

    @org.junit.Test
    public void generateToken() {
        //生成Token
        String s = JwtUtils.generateToken(new UserInfo(20L, "Jack"), privateKey, 5);
        System.out.println("s = " + s);
    }


    @org.junit.Test
    public void parseToken() {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiSmFjayIsImV4cCI6MTU2NzQzODUzOX0.csq8oX2CPvfQ28DdpCSiTZNQz19uUWHFGWCpiezlSH4hpB2SWVTGcOtDnOYh5t6EYz9GGqmAZdEbtLVnP8TibB-nWdQMZu6Q_XXe6Ina-yWXB4kuaKrlrBVbJI_io3ppt4zMgwP96wWhEkneotMHVkZbM_bU7ZbuueChEqRfKNQ";
        UserInfo userInfo = JwtUtils.getUserInfo(publicKey, token);
        System.out.println("id:" + userInfo.getId());
        System.out.println("name:" + userInfo.getName());
    }

    @org.junit.Test
    public void parseToken1() {
    }

    @org.junit.Test
    public void getUserInfo() {
    }

    @org.junit.Test
    public void getUserInfo1() {
    }
}