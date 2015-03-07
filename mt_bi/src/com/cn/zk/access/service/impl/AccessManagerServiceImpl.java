package com.cn.zk.access.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.dao.LoginDao;
import com.cn.zk.access.service.AccessManagerService;
import com.cn.zk.cache.BeanPostProcessorImpl;
import com.cn.zk.enums.CacheTypesEnums;
import com.cn.zk.enums.ResultEnum;
import com.cn.zk.enums.UserOperationEnum;
import com.cn.zk.util.MethodParamsData;
import com.cn.zk.util.MyStringUtil;
import com.cn.zk.util.ParamData;

public class AccessManagerServiceImpl implements AccessManagerService {
	private static final Logger log = Logger.getLogger(AccessManagerServiceImpl.class);
	private LoginDao loginDao;
	
	
	
	@Override
	public List<UserBean> findUserList(MethodParamsData arg) {
		UserBean userBean = (UserBean) arg.args[0];
		//从缓存中取
		List<UserBean> userBeans = (List<UserBean>) BeanPostProcessorImpl.getCacheData(CacheTypesEnums.USERSALL.ordinal());
		//从数据库中取
		if(userBeans == null){
			userBeans = loginDao.findUser();
		}
		if(userBeans == null || userBeans.size() <0){
			log.error("用户数据不存在，请检查异常");
		}
		return otherUserBean(userBeans,userBean);
	}
	
	
	
	@Override
	public ParamData operationUserBean(MethodParamsData arg,int type) {
		UserBean userBean = null;
		ParamData paramData = new ParamData();
		if(type == UserOperationEnum.ADD.type()){
			 int result = addUserBean(arg);
			 if(result == ResultEnum.SUCCESS.ordinal()){
				 paramData.resultEnume = ResultEnum.SUCCESS;
			 }else{
				 paramData.resultEnume = ResultEnum.ERROR;
			 }
		}
		
		if(type == UserOperationEnum.CHANGE.type()){
			
			
//			userBean = changePassword(arg);
		}
		if(type == UserOperationEnum.REMOVE.type()){
			
			 int result = removeUserBean(arg);
			 if(result == ResultEnum.SUCCESS.ordinal()){
				 paramData.resultEnume = ResultEnum.SUCCESS;
			 }else{
				 paramData.resultEnume = ResultEnum.ERROR;
			 }
		}
//		if(userBean!= null){
//			paramData.resultEnume = ResultEnum.SUCCESS;
//		}else{
//			 paramData.resultEnume = ResultEnum.ERROR;
//		}
		
		return paramData;
	}
	
	
	/**
	 * 添加用户 
	 * @param userBean
	 * @return
	 */
	public int addUserBean(MethodParamsData arg){
		try {
			UserBean userBean = (UserBean) arg.args[0];
			String[] modules = (String[]) arg.args[1];
			loginDao.saveUserBean(userBean);
			UserBean dbub = loginDao.getUserBean(userBean.getAccount(), userBean.getPassword());
			if(dbub != null){
				loginDao.saveUsesr_Module(dbub.getId(), MyStringUtil.arrToStr(modules, ","));
			}
			return ResultEnum.SUCCESS.ordinal();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEnum.ERROR.ordinal();
		}
	}
	
	
	
	/**
	 * 删除用户
	 * @param
	 * @return
	 */
	public int removeUserBean(MethodParamsData arg){
		int id = Integer.parseInt(arg.args[0].toString());
		try {
			BeanPostProcessorImpl.removeCacheData(CacheTypesEnums.USERSALL.ordinal(),id,new UserBean());
			loginDao.removeUserBean(id);
			loginDao.removeUserModule(id);
			return ResultEnum.SUCCESS.ordinal();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除用户数据异常 user:"+id);
			return ResultEnum.ERROR.ordinal();
		}
	}
	
	
	/**
	 * 修改用户
	 * @return
	 */
	public UserBean changePassword(MethodParamsData arg){
		UserBean userBean = (UserBean) arg.args[0];
		try{
			BeanPostProcessorImpl.addOrChangeCacheData(CacheTypesEnums.USER_MODULES.ordinal(), userBean.getId(), userBean);
			loginDao.saveUserBean(userBean);
			return userBean;
		}catch(Exception e){
			e.printStackTrace();
			log.error("修改用户数据异常 account:"+userBean.getAccount());
			return null;
		}
	}
	
	
	/**
	 * 过渡除自己以外的所有用户
	 * @param list
	 * @param self
	 * @return
	 */
	public List<UserBean> otherUserBean(List<UserBean> list ,UserBean self){
		List<UserBean> result = new ArrayList<UserBean>();
		for(UserBean ub : list){
			if(ub.getId() != self.getId()){
				result.add(ub);
			}
		}
		return result;
		
	}


	public LoginDao getLoginDao() {
		return loginDao;
	}


	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	
	

}
