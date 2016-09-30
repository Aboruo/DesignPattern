package com.aboruo.DesignPattern.Composite.entity;

public class Family {
	/** 家主 */
	private PersonNode houseHolder;
	public PersonNode getHouseHolder() {
		return houseHolder;
	}
	public void setHouseHolder(PersonNode houseHolder) {
		this.houseHolder = houseHolder;
	}
	public Family(PersonNode houseHolder){
		this.houseHolder = houseHolder;
	}
	public String toString(){
		return "家主是 ：" + houseHolder.getName() + " ,家主父母是：" + houseHolder.getParents().toString() + "，家主的孩子是：" + houseHolder.getChildren() ;
	}
}
