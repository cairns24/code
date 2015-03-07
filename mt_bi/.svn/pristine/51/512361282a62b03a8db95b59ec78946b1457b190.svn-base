package com.cn.zk.access.dao.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cn.zk.access.bean.UserBean;


/**
 * 封装 用户表 user -- UserBean映射关系
 * @author zhangkui
 *
 */
public class UserBeanRowMap implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		UserBean userBean = new UserBean();
		userBean.setAccount(rs.getString("account"));
		userBean.setPassword(rs.getString("password"));
		userBean.setId(rs.getInt("id"));
		userBean.setUserName(rs.getString("userName"));
		userBean.setPosition(rs.getInt("position"));
		return userBean;
	}

}
