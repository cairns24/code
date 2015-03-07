package com.cn.zk.interceptors;

import java.util.Map;



import com.cn.zk.access.bean.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class SessionInterceptor extends MethodFilterInterceptor {
	
//	private static final Object LOGIN_KEY = "admin";
	public static final String LOGIN_PAGE = "loginPage";

	@Override
//	public String intercept(ActionInvocation actionInvocation) throws Exception {
//		Map session = actionInvocation.getInvocationContext().getSession();
//		System.out.println("<><><><<><><><><><>");
//		UserBean ub = (UserBean) session.get("userBean");
//		
//		if(ub != null){
//			return actionInvocation.invoke();
//		}
////		Admin admin = (Admin) session.get(LOGIN_KEY);
////		if (admin != null) {
////			return actionInvocation.invoke();
////		} else {
////		}
//		return LOGIN_PAGE;
//	}

//	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		
		Map session = actionInvocation.getInvocationContext().getSession();
		System.out.println("<><><><<><><><><><>");
		UserBean ub = (UserBean) session.get("userBean");
		
		if(ub != null){
			return actionInvocation.invoke();
		}
//		Admin admin = (Admin) session.get(LOGIN_KEY);
//		if (admin != null) {
//			return actionInvocation.invoke();
//		} else {
//		}
		return LOGIN_PAGE;
//		return arg0.invoke();
	}
	
	
	
}
