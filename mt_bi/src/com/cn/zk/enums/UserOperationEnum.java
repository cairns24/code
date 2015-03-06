package com.cn.zk.enums;

public enum UserOperationEnum {
	ADD(1),CHANGE(2),REMOVE(3);
	  private UserOperationEnum(int type){
		this.type = type;
	}
	private int type;
	
	public int type(){
		return type;
	}
}
