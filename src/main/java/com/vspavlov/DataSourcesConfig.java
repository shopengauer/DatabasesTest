package com.vspavlov;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Vasiliy on 16.07.2015.
 */
@Configuration
public class DataSourcesConfig {

    @Bean
    public DataSource data(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("qwasw1979");

        ds.setMaxTotal(5);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource data){
       return new JdbcTemplate(data);
    }
//
//    @Bean
//    @Profile(value = "hsqldb")
//    public DataSource data1(){
//        BasicDataSource ds = new BasicDataSource();
//        ds.setUrl("jdbc:mysql://localhost:3306/test");
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUsername("root");
//        ds.setPassword("qwasw1979");
//
//        ds.setMaxTotal(5);
//        return ds;
//    }
//
//    @Bean
//    @Profile(value = "hsqldb")
//    public JdbcTemplate jdbcTemplate1(DataSource data1){
//       return new JdbcTemplate(data1);
//    }
//

}
