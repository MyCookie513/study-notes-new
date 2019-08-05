package com.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jason.mapper")
public class BootdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class,args);
    }
}
