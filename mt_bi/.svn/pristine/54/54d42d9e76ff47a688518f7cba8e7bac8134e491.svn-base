package com.cn.zk.access.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cn.zk.access.bean.ModuleBean;
import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.bean.User_Module;
import com.cn.zk.access.dao.LoginDao;
import com.cn.zk.access.dao.bean.ModuleBeanRowMap;
import com.cn.zk.access.dao.bean.UserBeanRowMap;
import com.cn.zk.access.dao.bean.UserModuleRowMap;
import com.cn.zk.dao.IDao;

/**
 * 
 * @author zhangkui
 *
 */
public class LoginDaoImpl extends IDao implements LoginDao {
	
	private static final Logger log = Logger.getLogger(LoginDaoImpl.class);
	
	@Override
	public UserBean getUserBean(int id) {
		Object[] obj = new Object[1];
		obj[0] = id;
//		Map<String, Object> map = getJdbcTemplate().queryForMap("select * from user where id =?",obj);
		List<UserBean>  list = getJdbcTemplate().query("select * from user where id=?", obj,new UserBeanRowMap());
		if(list == null || list.size()<=0) return null;
		return list.get(0);
	}
	
	@Override
	public List<User_Module> findUserModule() {
		String sql = "select * from user_module";
		List<User_Module> list = getJdbcTemplate().query(sql, new UserModuleRowMap());
		return list;
	}
	
	
	@Override
	public List<UserBean> findUser() {
		List<UserBean> list = getJdbcTemplate().query("select * from user",new UserBeanRowMap());
		return list;
	}

	@Override
	public List<ModuleBean> findModules() {
		List<ModuleBean> list = getJdbcTemplate().query("select * from module",new ModuleBeanRowMap());
		return list;
	}



	@Override
	public void removeUserBean(int id) {
		getJdbcTemplate().execute("delete from user where id="+id);
	}

	
	@Override
	public void removeUserModule(int id) {
		getJdbcTemplate().execute("delete from user_module where userId="+id);
	}
	
	@Override
	public void saveUserBean(UserBean userBean) {
		if(getUserBean(userBean.getId()) != null && userBean.getId() >0){
			Object[] objs  =  new Object[3];
			objs[0] = userBean.getAccount();
			objs[1] = userBean.getPassword();
			objs[2] = userBean.getId();
			getJdbcTemplate().update("update user set  name=? ,password = ?,userName = ? where id = ?", objs);
		}else{
			Object[] objs2  =  new Object[4];
			objs2[0] = userBean.getAccount();
			objs2[1] = userBean.getPassword();
			objs2[2] = userBean.getUserName();
			objs2[3] = userBean.getPosition();
			getJdbcTemplate().update("INSERT INTO user (account,password,userName,position) value(?,?,?,?);", objs2);
		}
	}
	
	@Override
	public UserBean getUserBean(String account, String password) {
		String sql ="select * from user where account=? and password = ?";
		Object[] objs = new Object[2];
		objs[0] = account;
		objs[1] = password;
		List<UserBean> list = getJdbcTemplate().query(sql, objs,new UserBeanRowMap());
		if(list == null || list.size() <=0)return null;
		return list.get(0);
	}
	
	
	@Override
	public User_Module getUser_Module(int userId) {
		Object[] objs = new Object[1];
		objs[0] = userId;
		String sql = "select * from user_module where userId=?";
		List<User_Module> list = getJdbcTemplate().query(sql, objs,new UserModuleRowMap());
		if(list == null || list.size() <0 ) return null;
		return list.get(0);
	}
	
	@Override
	public void saveUsesr_Module(int userId,String modules) {
		String sql = "INSERT INTO user_module (userId,modules) value(?,?)";
		Object[] objs = new Object[2];
		objs[0] = userId;
		objs[1] = modules;
		getJdbcTemplate().update(sql,objs);
	}

}
