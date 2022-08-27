package com.worldance.test.mybatis.model;

public class SqlBuildTables {
    private Integer pid;

    private String tableRegName;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTableRegName() {
        return tableRegName;
    }

    public void setTableRegName(String tableRegName) {
        this.tableRegName = tableRegName == null ? null : tableRegName.trim();
    }
}