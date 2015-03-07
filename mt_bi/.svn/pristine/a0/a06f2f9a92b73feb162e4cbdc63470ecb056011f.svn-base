package com.cn.zk.access.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.cn.zk.access.bean.UserBean;
import com.cn.zk.access.service.LoginService;
import com.cn.zk.enums.PositionEnum;
import com.cn.zk.enums.ResultEnum;
import com.cn.zk.util.MethodParamsData;
import com.cn.zk.util.ParamData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author zhangkui
 *
 */
public class UserLoginAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private HttpServletResponse response;
	private HttpServletRequest request;
	private static final Logger log = Logger.getLogger(UserLoginAction.class);
	
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户登陆
	 * @return
	 * @throws Exception
	 */
	public String userLogin() throws Exception {
		MethodParamsData mpd = new MethodParamsData();
		
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd"); 
		String[] args = new String[2];
		args[0] = account;
		args[1] = pwd;
		mpd.args = args;
		ParamData parm = loginService.loginOption(mpd);
		if(parm.resultEnume == ResultEnum.ERROR){
			return "ERROR";
		}
		UserBean user = (UserBean) parm.args[0];
//		request.setAttribute("accessModules", user.getModules());
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("accessModules", user.getModules());
//		session.put("userName", user.getAccount());
		session.put("userBean", user);
		return "success";
	}
	
	/**
	 * 用户退出 
	 * @return
	 * @throws Exception
	 */
	public String quitLogin()throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session != null || session.size()>0){
			session.clear();
		}
		return "quit";
	}
	
	/**
	 * 用户退出 
	 * @return
	 * @throws Exception
	 */
	public String findUsers()throws Exception{
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		if(session != null || session.size()>0){
//			session.clear();
//		}
		
		return "findUsersSuccess";
	}
	

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
