package com.jason.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LyUploadApplicationTests {

    @Test
    public void contextLoads() {
        try{
            File dir = new File("static");
            System.out.println(dir.getPath());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
