package com.cn.zk.access.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mbeans.UserMBean;
import org.apache.log4j.Logger;

import com.cn.zk.access.bean.ModuleBean;
import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.bean.User_Module;
import com.cn.zk.access.dao.LoginDao;
import com.cn.zk.access.service.LoginService;
import com.cn.zk.cache.BeanPostProcessorImpl;
import com.cn.zk.enums.CacheTypesEnums;
import com.cn.zk.enums.ResultEnum;
import com.cn.zk.util.MethodParamsData;
import com.cn.zk.util.ParamData;
import com.sun.xml.internal.ws.api.server.Module;

public class LoginServiceImpl implements LoginService {
	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);
	private LoginDao loginDao;

	@Override
	public ParamData loginOption(MethodParamsData args) {
		ParamData param = new ParamData();
		try {
			UserBean userBean = null;
			List<UserBean> users = (List<UserBean>) BeanPostProcessorImpl
					.getCacheData(CacheTypesEnums.USERSALL.ordinal());
			if (users == null || users.size() < 0) {
				log.info("所有有用户缓存数据为null--------------");
				userBean = loginDao.getUserBean(args.args[0].toString(),
						args.args[1].toString());
				if (userBean != null) {
					users = new ArrayList<UserBean>();
					users.add(userBean);
					BeanPostProcessorImpl.addCache(
							CacheTypesEnums.USERSALL.ordinal(), users);
				}
			} else {
				userBean = findUserBeanByAccount(users, args.args[0].toString(),args.args[1].toString());
			}
			Object[] objs = new Object[1];
			if (userBean == null) {
				param.resultEnume = ResultEnum.ERROR;
			} else {
				userBean.setModules(getModulesbyUserId(userBean));
				param.resultEnume = ResultEnum.SUCCESS;
				objs[0] = userBean;
				param.args = objs;
			}
			return param;
		} catch (Exception e) {
			log.error("MethodParamsData 参数 为Null,请检查传递的参数............");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过玩家用户获取用户所拥有的模块 
	 * @param ub
	 * @return
	 */
	public List<ModuleBean> getModulesbyUserId(UserBean ub){
		User_Module um = getModuleBeanforUser(ub);
		List<ModuleBean> list = getModulesById(um.getModuleId());
		return list;
	}
	/**
	 * 获得指定模块信息
	 * @param ids 模块id
	 * @return
	 */
	public List<ModuleBean> getModulesById(int[] ids){
		List<ModuleBean> modules = (List<ModuleBean>)BeanPostProcessorImpl.getCacheData(CacheTypesEnums.MODULES.ordinal());
		if(modules == null){
			modules = loginDao.findModules();
			if(modules == null){
				log.error("缓存与数据库中模块信息不存在请检查模块数据..............");
				return null;
			}else{
				BeanPostProcessorImpl.addCache(CacheTypesEnums.MODULES.ordinal(), modules);
			}
		}
		List<ModuleBean> result = new ArrayList<ModuleBean>();
		for(ModuleBean  mb : modules){
			for(int id : ids){
				if(mb.getId() == id)
					result.add(mb);
			}
		}
		return result;
	}
	
	/**
	 * 获得指定用户信息的用 户模块信息
	 * @param user
	 * @return
	 */
	public User_Module getModuleBeanforUser(UserBean user){
		List<User_Module> ums = (List<User_Module>)BeanPostProcessorImpl.getCacheData(CacheTypesEnums.USER_MODULES.ordinal());
		User_Module  um = null;
		if(ums != null && ums.size() >0){
			um = getUser_ModuleByUserId(ums,user.getId());
		}else{
			um = loginDao.getUser_Module(user.getId());
			if(um != null){
				ums = new ArrayList<User_Module>();
				ums.add(um);
				BeanPostProcessorImpl.addCache(CacheTypesEnums.USER_MODULES.ordinal(), ums);
			}
		}
		if(um == null){
			log.error("指定用户的模块信息在缓存与数据库中不存在请检查该用户是分配正确..................");
		}
		return um;
	}
	
	
	
	/**
	 * 查询在用户模块缓存 中 指定用户的模块信息
	 * @param listv
	 * @param userId
	 * @return
	 */
	public User_Module getUser_ModuleByUserId(List<User_Module> list ,int userId){
		for(User_Module um : list){
			if(um.getUserId() == userId){
				return um;
			}
		}
		return null;
	}

	/**
	 * 查询在用户缓存中 指定用户id的用户信息
	 * 
	 * @param list
	 * @param userId
	 * @return
	 */
	public UserBean findUserBeanByUserId(List<UserBean> list, int userId) {
		for (UserBean b : list) {
			if (b.getId() == userId) {
				return b;
			}
		}
		return new UserBean();
	}

	/**
	 * 查询在用户缓存中 指定用户帐号的用户信息
	 * 
	 * @param list
	 * @param account
	 *            不区分大小写
	 * @return
	 */
	public UserBean findUserBeanByAccount(List<UserBean> list, String account,String password) {
		for (UserBean b : list) {
			if (b.getAccount().equalsIgnoreCase(account) && b.getPassword().equalsIgnoreCase(password)) {
				return b;
			}
		}
		return null;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
