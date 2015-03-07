package com.cn.zk.access.dao.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cn.zk.access.bean.User_Module;


/**
 * 封装 数据表与User_Module映射关系
 * @author zhangkui
 *
 */
public class UserModuleRowMap implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		User_Module um = new User_Module();
		String s = rs.getString("modules");
		String[] strArr = s.split(",");
		if(strArr != null && strArr.length >0 ){
			um.setModuleId(tranfIntArr(strArr));
		}
		um.setUserId(rs.getInt("userId"));
		return um;
	}
	
	
	public int[] tranfIntArr(String[] arr){
		int[] inarr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			inarr[i] = Integer.parseInt(arr[i]);
		}
		return inarr;
	}

}
