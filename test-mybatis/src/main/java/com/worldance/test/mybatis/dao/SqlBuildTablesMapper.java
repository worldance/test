package com.worldance.test.mybatis.dao;

import com.worldance.test.mybatis.model.SqlBuildTables;

public interface SqlBuildTablesMapper {
    int insert(SqlBuildTables record);

    int insertSelective(SqlBuildTables record);
    
    SqlBuildTables getSqlBuildTablesById(int pid);
}