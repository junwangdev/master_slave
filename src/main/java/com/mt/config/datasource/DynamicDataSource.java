package com.mt.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    //这个方法的作用是 通过返回的数据库名称 获取对应的数据库
    @Override
    protected Object determineCurrentLookupKey() {
        //如果ThreadLocal 内有
        if(DataSourceHolder.getDataSource()!=null){
            return DataSourceHolder.getDataSource();
        }
        //如果ThreadLocal 内没有 则用 slave
        return DataSourceType.SLAVE.getType();
    }

}
