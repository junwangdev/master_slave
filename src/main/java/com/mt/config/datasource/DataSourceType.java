package com.mt.config.datasource;

public enum DataSourceType {
    MASTER("master","主库"),SLAVE("slave","从库");

    private String name;
    private String type;

    private DataSourceType(String name,String type){
        this.name =name;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String naem) {
        this.name = naem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
