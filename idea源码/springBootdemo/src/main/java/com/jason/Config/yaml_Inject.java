package com.jason.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;


@Data
@ConfigurationProperties(prefix = "testinject")
public class yaml_Inject {

    private String  pen;
    private User user;
    @Data
    class User {
        String name ;
        int age ;
        List<String> languages;
    }
}
