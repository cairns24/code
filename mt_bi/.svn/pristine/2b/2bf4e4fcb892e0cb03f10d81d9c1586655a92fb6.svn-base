package com.cn.zk.access.dao;

import java.util.List;

import org.apache.catalina.mbeans.UserMBean;

import com.cn.zk.access.bean.ModuleBean;
import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.bean.User_Module;


/**
 * 
 * @author zhangkui
 *
 */
public interface LoginDao{
	
	
	
	/**
	 * 删除指定玩家信息
	 * @param id 用户id
	 */
	public void removeUserBean(int id);
	/**
	 * 保存用户信息
	 * @param id  用户id
	 */
	public void saveUserBean(UserBean bean);
	
	/**
	 * 获得指定用户信息
	 * @param id 用户id
	 * @return
	 */
	public UserBean getUserBean(int id);
	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	public List<UserBean> findUser();
	
	/**
	 * 获取所有模块信息
	 * @return
	 */
	public List<ModuleBean> findModules();
	
	/**
	 * 获取所有用户拥有的模块信息
	 * @return
	 */
	public List<User_Module> findUserModule();
	
	/**
	 * 获取指定用户便利店 
	 * @param account 用户帐号
	 * @param password 用户密码   未加密
	 * @return
	 */
	public UserBean getUserBean(String account,String password);
	
	
	/**
	 * 获得指定用户的用户模块信息
	 * @param userId
	 * @return
	 */
	public User_Module getUser_Module(int userId);
	
	/**
	 * 保存用户权限信息
	 * @param um
	 */
	public void saveUsesr_Module(int userId,String modules);
	
	/**
	 * 删除指定玩家信息
	 * @param id 用户id
	 */
	public void removeUserModule(int id);
	
		

}
