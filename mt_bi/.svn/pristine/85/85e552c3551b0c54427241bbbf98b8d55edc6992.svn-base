package com.cn.zk.util;

import java.io.Serializable;

/**
 * 方法间传递参数封装对象
 * @author zhangkui
 *
 */
public class MethodParamsData implements Serializable {
	
	/**
	 * 所需要传递 的参数  此参数必须保持顺序一致 否则数据混乱 
	 */
	public Object[] args;
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(args != null){
			for(Object o : args){
				sb.append("args").append(":");
			}
		}else{
			return super.toString();
		}
		return sb.toString();
	}

}
