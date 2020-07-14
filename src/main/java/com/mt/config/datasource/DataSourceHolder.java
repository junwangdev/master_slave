package com.mt.config.datasource;

public class DataSourceHolder {
    private static final ThreadLocal<String> holder =new ThreadLocal<>();


    public static void putDataSource(DataSourceType dataSourceType){
        holder.set(dataSourceType.getType());
    }

    public static String getDataSource(){
        return holder.get();
    }
}
