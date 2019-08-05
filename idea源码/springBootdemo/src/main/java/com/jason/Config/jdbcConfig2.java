package com.jason.Config;

/*
import com.alibaba.druid.pool.DruidDataSource;
*/
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(jdbcProperties.class)
public class jdbcConfig2 {

   /* @Bean
    public DataSource dataSource(jdbcProperties prop){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(prop.getDriverClassName());
        druidDataSource.setUrl(prop.getUrl());
        druidDataSource.setUsername(prop.getUsername());
        druidDataSource.setPassword(prop.getPassword());
        return druidDataSource;
    }*/

}
