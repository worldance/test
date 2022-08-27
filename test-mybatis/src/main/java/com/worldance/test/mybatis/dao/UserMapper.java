package com.worldance.test.mybatis.dao;

import com.worldance.test.mybatis.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAll();

    List<User> getAll2();

    List<User> getAll3();
}