package com.cn.zk.test.dao;


public class JdbcTemplateTest extends IDao implements JdbcDao{

	public void save() {
		
		getJdbcTemplate().execute("");
	}
	
	
	

}
