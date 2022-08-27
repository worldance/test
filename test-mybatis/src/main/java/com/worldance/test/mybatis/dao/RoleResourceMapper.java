package com.worldance.test.mybatis.dao;

import com.worldance.test.mybatis.model.RoleResource;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
}