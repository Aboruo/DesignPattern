package com.aboruo.DesignPattern.chainofresponsibility.abs.impl;

import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;
import com.alibaba.fastjson.JSONObject;

public class BusinessDealChainImpl extends BusinessDealChain {
	private JSONObject retResult;
	public JSONObject getRetResult() {
		return retResult;
	}
	public void setRetResult(JSONObject retResult) {
		this.retResult = retResult;
	}
	@Override
	public void doDealChain(Map<String, Object> businessInfo) {
		BusinessDealDao businessDealDao = getBusinessDealDao();
		if(businessDealDao != null)  businessDealDao.doDeal(businessInfo,this);
		return;
	}

}
