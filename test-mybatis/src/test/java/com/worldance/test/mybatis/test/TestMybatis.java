package com.worldance.test.mybatis.test;

import java.util.List;

import com.worldance.test.mybatis.model.SqlBuildTables;
import com.worldance.test.mybatis.model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worldance.test.mybatis.model.SqlBuildTables;
import com.worldance.test.mybatis.model.User;
import com.worldance.test.mybatis.service.SqlBuildService;
import com.worldance.test.mybatis.service.UserServiceI;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	private UserServiceI userService;
	private SqlBuildService sqlBuildService;


	@Test
	public void testGetSqlBuildTablesById() {
	    System.out.println(System.getProperty("jdbc.url"));
        int pid =1 ;
        SqlBuildTables record = sqlBuildService.getSqlBuildTablesById(pid);
        System.out.println(record.getPid()+","+record.getTableRegName());
	}
	

	@Test
	public void test1() {
		User u = userService.getUserById("1");
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test2() {
		List<User> l = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test3() {
		List<User> l = userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test4() {
		List<User> l = userService.getAll3();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

   public UserServiceI getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }
	
    public SqlBuildService getSqlBuildService() {
        return sqlBuildService;
    }

    @Autowired
    public void setSqlBuildService(SqlBuildService sqlBuildService) {
        this.sqlBuildService = sqlBuildService;
    }
	
	
}
