package com.worldance.test.mybatis.service;

import com.worldance.test.mybatis.dao.SqlBuildTablesMapper;
import com.worldance.test.mybatis.model.SqlBuildTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sqlBuildService")
public class SqlBuildServiceImpl implements SqlBuildService {
	
	private SqlBuildTablesMapper buildTablesMapper;

	public SqlBuildTables getSqlBuildTablesById(int pid) {
		
		return buildTablesMapper.getSqlBuildTablesById(pid);
	}

	public SqlBuildTablesMapper getBuildTablesMapper() {
		return buildTablesMapper;
	}

	@Autowired
	public void setBuildTablesMapper(SqlBuildTablesMapper buildTablesMapper) {
		this.buildTablesMapper = buildTablesMapper;
	}
	
	
	

}
