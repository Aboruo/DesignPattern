package com.aboruo.DesignPattern.chainofresponsibility.abs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;

public abstract class BusinessDealChain {
	private List<BusinessDealDao> businessDealList = new LinkedList<BusinessDealDao>();
	private int index = 0;
	
	public void addDeal(BusinessDealDao businessDealDao){
		businessDealList.add(businessDealDao);
	}
	public List<BusinessDealDao> getBusinessDealList() {
		return businessDealList;
	}
	public void setBusinessDealList(List<BusinessDealDao> businessDealList) {
		this.businessDealList = businessDealList;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public BusinessDealDao getBusinessDealDao(){
		if(index < businessDealList.size()) return businessDealList.get(index++);
		return null;
	}
	public abstract void doDealChain(Map<String, Object> businessInfo);
}
