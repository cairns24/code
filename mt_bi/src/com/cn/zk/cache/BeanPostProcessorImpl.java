package com.cn.zk.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.cn.zk.access.bean.ModuleBean;
import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.bean.User_Module;
import com.cn.zk.access.dao.LoginDao;
import com.cn.zk.enums.CacheTypesEnums;


/**
 * 初始数据加载至缓存
 * @author zhangkui
 *
 */
public class BeanPostProcessorImpl implements BeanPostProcessor{
	
	private LoginDao loginDao;
	
	/**
	 * 后台管理用户所有数据信息
	 * key
	 */
	private static Map<Integer,Object> map = new HashMap<Integer, Object>();
	
	private BeanPostProcessorImpl(){
		
	}
	
	/**
	 * 获得指定缓存信息
	 * @param key
	 * @return
	 */
	public static Object getCacheData(int key){
		return map.get(key);
	}
	
	
	
	
	/**
	 * 添加或修改缓存数据
	 * @param key
	 * @param id
	 * @param c
	 */
	public static void addOrChangeCacheData(int key,int id,Object c){
		if(c instanceof UserBean){
			addOrChangeUserBean(key,(UserBean)c);
		}
		if(c instanceof ModuleBean){
			
		}
		if(c instanceof User_Module){
			addOrChangeUserModule(key,(User_Module)c);
		}
	}
	

	/**
	 * 添加or修改userBean
	 * @param key
	 * @param u
	 */
	public static void addOrChangeUserBean(int key,UserBean u){
		List<UserBean> list = (List<UserBean>) getCacheData(key);
		if(list != null){
			if(isUserBeanExist(list, u)){
				removeUserBean(key, u.getId());
				list.add(u);
			}else{
				list.add(u);
			}
		}
	}
	
	/**
	 * 添加or修改userBean
	 * @param key
	 * @param u
	 */
	public static void addOrChangeUserModule(int key,User_Module u){
		List<User_Module> list = (List<User_Module>) getCacheData(key);
		if(list != null){
			if(isUserModuleExist(list, u)){
				removeUserModule(key, u.getUserId());
				list.add(u);
			}else{
				list.add(u);
			}
		}
	}
	
	
	private static boolean isUserModuleExist(List<User_Module> list,User_Module u){
		for(User_Module ub : list){
			if(ub.getUserId() == u.getUserId()){
				return true;
			}
		}
		return false;
	}
	
	
	
	private static boolean isUserBeanExist(List<UserBean> list,UserBean u){
		for(UserBean ub : list){
			if(ub.getId() == u.getId()){
				return true;
			}
		}

		return false;
	}
	
	
	
	
	
	/**
	 * 移除缓存数据
	 * @param key 用户信息 UserBean  模块信息 MobuleBean    用户权限信息 User_Module
	 * @param id 索引
	 * @param c 要操作的对象
	 */
	public static void removeCacheData(int key,int id,Object c){
		if(c instanceof UserBean){
			removeUserBean(key,id);
		}
		if(c instanceof ModuleBean){
			
			removeModuleBean(key,id);
		}
		if(c instanceof User_Module){
			removeUserModule(key,id);
		}
	}
	
	
	/**
	 * 移除用户信息
	 * @param key
	 * @param id
	 */
	private static void removeUserBean(int key,int id){
		List<UserBean>  userBeans  =   (List<UserBean>) getCacheData(key);
		if(userBeans != null){
			for(UserBean ub : userBeans){
				if(ub.getId() == id){
					userBeans.remove(ub);
				}
			}
		}
		
	}
	
	
	/**
	 * 移除模块信息
	 * 此方法一般不会用到，慎用
	 * @param key
	 * @param id
	 */
	private static void removeModuleBean(int key,int id){
		List<ModuleBean>  moduleBeans  =   (List<ModuleBean>) getCacheData(key);
		if(moduleBeans != null){
			for(ModuleBean mb : moduleBeans){
				if(mb.getId() == id){
					moduleBeans.remove(mb);
				}
			}
		}
		
	}
	
	
	/**
	 * 移除模块信息
	 * 此方法一般不会用到，慎用
	 * @param key
	 * @param id
	 */
	private static void removeUserModule(int key,int id){
		List<User_Module>  user_modules  =   (List<User_Module>) getCacheData(key);
		if(user_modules != null){
			for(User_Module u_b : user_modules){
				if(u_b.getUserId() == id){
					user_modules.remove(u_b);
				}
			}
		}
		
	}
	
	
	/**
	 * 获得所有缓存信息
	 * @return
	 */
	public static List<Object> getAllCacheData(){
		return new ArrayList<Object>(map.values());
	}
	
	/**
	 * 销毁所有缓存信息
	 */
	public static void destroy(){
		map.clear();
		
	}
	
	/**
	 * 添加用户信息至缓存中做及时更新
	 * @param key
	 * @param value
	 */
	public static void addCache(int key,Object value){
		map.put(key, value);
	}
	
	
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		
			List<UserBean> userBeans = loginDao.findUser();
			List<ModuleBean> moduleBeans = loginDao.findModules();
			List<User_Module> user_module=  loginDao.findUserModule();
			
			if(userBeans != null && userBeans.size() >0){
				map.put(CacheTypesEnums.USERSALL.ordinal(), userBeans);
			}
			if(moduleBeans != null && moduleBeans.size() >0){
				map.put(CacheTypesEnums.MODULES.ordinal(), moduleBeans);
			}
			if(user_module != null && user_module.size() >0 ){
				map.put(CacheTypesEnums.USER_MODULES.ordinal(), user_module);;
			}
		return arg0;
	}
	

	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		return arg0;
	}


	public LoginDao getLoginDao() {
		return loginDao;
	}


	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


}
