package com.cn.zk.access.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.service.AccessManagerService;
import com.cn.zk.enums.PositionEnum;
import com.cn.zk.enums.ResultEnum;
import com.cn.zk.enums.UserOperationEnum;
import com.cn.zk.util.MD5Util;
import com.cn.zk.util.MethodParamsData;
import com.cn.zk.util.ParamData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 后台管理
 * @author zhangkui
 *
 */
public class AccessManagerAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private AccessManagerService accessManagerService;
	private static final Logger log = Logger.getLogger(AccessManagerAction.class);
	//来宾用户
	private static final int position =2;
	
	/**
	 * 查看用户信息
	 * @return
	 * @throws Exception
	 */
	public String findUserList() throws Exception{
		Map<String,Object> session = ActionContext.getContext().getSession();
		UserBean userBean = (UserBean) session.get("userBean");
		
		if(userBean == null){
			return "error";
		}
		if(userBean.getPosition() == PositionEnum.ADMIN.getPosition()){
			MethodParamsData meData = new MethodParamsData();
			Object[] obj = new Object[1];
			obj[0] = userBean; 
			meData.args =obj;
			List<UserBean> userList = accessManagerService.findUserList(meData);
			ActionContext.getContext().getParameters().put("userList", userList);
			request.setAttribute("userListsss", userList);
			
		}else{
			log.error("非法操作该用户非管理员........."+"帐号:"+userBean.getAccount());
			return "findUserErrorr";
		}
		
		return "findUserSuccess";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String registerSkip(){
		return "reSkipSuccess";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		UserBean admin = (UserBean) session.get("userBean");
		if(admin == null){
			return "error";
		}
		if(admin.getPosition() == PositionEnum.ADMIN.getPosition()){
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			password=MD5Util.getMd5(password);
			String userName = request.getParameter("userName");
			String[] modules =request.getParameterValues("modules");
			
			UserBean guest = new UserBean();
			guest.setAccount(account);
			guest.setPassword(password);
			guest.setPosition(position);
			guest.setUserName(userName);
			MethodParamsData arg = new MethodParamsData();
			Object[] obj = new Object[2];
			obj[0] = guest;
			obj[1] = modules;
			arg.args = obj;
			ParamData paramData = accessManagerService.operationUserBean(arg, UserOperationEnum.ADD.type());
			if(paramData.resultEnume == ResultEnum.SUCCESS){
				return "addUserSuccess";
				
			}
		}

		return "addUserError";
	}
	
	
	/**
	 * 修改密码暂时不加
	 * @return
	 */
//	public String changePassword(){
//		Map<String,Object> session = ActionContext.getContext().getSession();
//		UserBean admin = (UserBean) session.get("userBean");
//		if(admin == null){
//			return "error";
//		}
//		if(admin.getPosition() == PositionEnum.ADMIN.getPosition()){
//			String account = request.getParameter("account");
//			String password = request.getParameter("password");
//			String userName = request.getParameter("userName");
//			UserBean guest = new UserBean();
//			guest.setAccount(account);
//			guest.setPassword(password);
//			guest.setPosition(position);
//			guest.setUserName(userName);
//			MethodParamsData arg = new MethodParamsData();
//			Object[] obj = new Object[1];
//			obj[0] = guest;
//			arg.args = obj;
//			ParamData paramData = accessManagerService.operationUserBean(arg, UserOperationEnum.ADD.type());
//			if(paramData.resultEnume == ResultEnum.SUCCESS){
//				return "addUserSuccess";
//				
//			}
//		}
//		return "changepwdSuccess";
//	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String removeUser(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		UserBean admin = (UserBean) session.get("userBean");
		if(admin == null){
			return "error";
		}
		if(admin.getPosition() == PositionEnum.ADMIN.getPosition()){
			int id  = Integer.parseInt(request.getParameter("id"));
			MethodParamsData arg = new MethodParamsData();
			Object[] obj = new Object[1];
			obj[0] = id;
			arg.args = obj;
			ParamData paramData = accessManagerService.operationUserBean(arg, UserOperationEnum.REMOVE.type());
			if(paramData.resultEnume == ResultEnum.SUCCESS){
				return "removeUserSuccess";
				
			}
		}
		
		return "removeUserError";
	}


	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}


	public AccessManagerService getAccessManagerService() {
		return accessManagerService;
	}

	public void setAccessManagerService(AccessManagerService accessManagerService) {
		this.accessManagerService = accessManagerService;
	}
}
