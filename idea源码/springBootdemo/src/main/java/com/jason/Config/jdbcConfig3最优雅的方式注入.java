package com.jason.Config;

/*import com.alibaba.druid.pool.DruidDataSource;*/
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class jdbcConfig3最优雅的方式注入 {

   /* @Bean
    @ConfigurationProperties(prefix="jdbc")
    public DruidDataSource getDruidDataSource(){
        return new DruidDataSource();
    }
    @Bean
    @ConfigurationProperties(prefix="testinject")
    public yaml_Inject getjaml(){
        return new yaml_Inject();
    }*/
}
