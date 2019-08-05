package com.jason.Config;

/*import com.alibaba.druid.pool.DruidDataSource;*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;




@Configuration
@PropertySource("classpath:DataSource.properties")
//@EnableConfigurationProperties(jdbcProperties.class)
public class jdbcConfig {


/*
    *//**
     * 第一种方式来获取配置文件中的内容；
     *//*
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }*/
}
