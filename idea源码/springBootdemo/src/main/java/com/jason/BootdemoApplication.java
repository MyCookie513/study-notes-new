package com.jason;

import com.jason.Config.yaml_Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jason.mapper")
public class BootdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class,args);
    }



}
