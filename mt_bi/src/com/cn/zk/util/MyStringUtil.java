package com.cn.zk.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zk
 *
 */
public class MyStringUtil {
	
	private MyStringUtil() {
	}
	/**
	 * 
	 * @param arrs 格式  xx_xx,xx_xx
	 * @return
	 */
	public static Map<Object,Object>  analyzeStringArray(String[] arrs){
		Map<Object,Object> map = new HashMap<Object, Object>();
		for(String str : arrs){
			String[] sAr=str.split("_");
			if(sAr.length ==2){
				map.put(sAr[0], sAr[1]);
			}
		}
		return map;
	}
	
	/**
	 * 得到根据str连接后的字符串
	 * 
	 * @param collection
	 * @param joinStr
	 * @return
	 */
	public static String getJoinString(Collection<String> collection, String joinStr) {
		// 得到应该插入的面板玩家ids字符串
		StringBuilder sb = new StringBuilder();
		for (String member : collection) {
			sb.append(member);
			sb.append(joinStr);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	

	public static String arrToStr(String[] strs,String c){
		StringBuffer sb = new StringBuffer();
		for(String s : strs){
			sb.append(s).append(c);
		}
		return sb.substring(0,sb.lastIndexOf(c));
	}
	public static void main(String[] args) {
		String[] ss = {"1","3"};
		System.out.println(arrToStr(ss, ","));
		
	}
	
	

}
