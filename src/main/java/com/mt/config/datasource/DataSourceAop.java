package com.mt.config.datasource;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Before(value = "@annotation(dataSource)")
    public void before(JoinPoint joinpoint, DataSource dataSource){
        System.out.println("当前数据库===>"+dataSource.value().getType());
        DataSourceHolder.putDataSource(dataSource.value());
    }
}
