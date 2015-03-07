package com.cn.zk.access.bean;

import java.io.Serializable;
import java.util.List;

import com.sun.xml.internal.ws.api.server.Module;

/**
 * 
 * @author zhangkui
 * 
 */
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	// 帐号
	private String account;
	// 密码
	private String password;
	// 昵称
	private String userName;
	//职位
	private int position;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	//模块信息
	private List<ModuleBean> modules;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public List<ModuleBean> getModules() {
		return modules;
	}

	public void setModules(List<ModuleBean> modules) {
		this.modules = modules;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
