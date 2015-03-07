package com.cn.zk.access.dao.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cn.zk.access.bean.ModuleBean;
import com.cn.zk.access.bean.UserBean;

/**
 * 封装模块 module------ModuleBean 映射关系 
 * @author zhangkui
 *
 */
public class ModuleBeanRowMap implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		ModuleBean bean = new ModuleBean();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setUrl(rs.getString("url"));
		return bean;
	}

}
