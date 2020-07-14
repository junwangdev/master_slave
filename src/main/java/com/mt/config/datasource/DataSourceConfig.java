package com.mt.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.master.datasource")
    public HikariDataSource masterDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.slave.datasource")
    public HikariDataSource slaveDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }



    private Map<Object,Object> targetDataSources(){
        Map<Object,Object> targetDataSources = new HashMap<>();
        //key 为 master时 使用master 数据源
        targetDataSources.put(DataSourceType.MASTER.getType(), masterDataSource());
        // key 为 slave 时 使用 slave数据源
        targetDataSources.put(DataSourceType.SLAVE.getType(), slaveDataSource());
        return targetDataSources;
    }

    @Bean(name = "dynamicDataSource")
    //解决互相依赖关系
    @DependsOn({ "masterDataSource", "slaveDataSource"}) //在指定类加载后加载
    @Primary
    public javax.sql.DataSource getDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources());
        return dataSource;
    }


}
