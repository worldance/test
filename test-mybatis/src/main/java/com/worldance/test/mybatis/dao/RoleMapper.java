package com.worldance.test.mybatis.dao;

import com.worldance.test.mybatis.model.Role;
import com.worldance.test.mybatis.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}