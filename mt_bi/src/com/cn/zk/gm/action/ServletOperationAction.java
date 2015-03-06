package com.cn.zk.gm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ServletOperationAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final Logger log = Logger.getLogger(ServletOperationAction.class);
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	
	/**
	 * 开服
	 * @return
	 */
	public String startServlet(){
		
		
		
		return "";
	}
	
	/**
	 * 关闭服
	 * @return
	 */
	public String stopServlet(){
		return "";
	}
	
	
	/**
	 * 获得所有服务信息
	 * @return
	 */
	public String findServlets(){
		
		return "";
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
