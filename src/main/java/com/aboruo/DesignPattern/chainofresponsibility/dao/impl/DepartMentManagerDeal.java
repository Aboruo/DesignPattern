package com.aboruo.DesignPattern.chainofresponsibility.dao.impl;

import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;
import com.alibaba.fastjson.JSONObject;

public class DepartMentManagerDeal implements BusinessDealDao {

	@Override
	public JSONObject doDeal(Map<String, Object> businessInfo, BusinessDealChain businessDealChain) {
		JSONObject retValue = new JSONObject();
		String applyFundsStr = businessInfo.containsKey("applyFunds") ? businessInfo.get("applyFunds").toString() : "0.0";
		double applyFunds = Double.parseDouble(applyFundsStr);
		
		if(applyFunds <= 0 || applyFunds >= 100000){
			retValue.put("status", 0);
			retValue.put("message", "申请不符合条件......");
		}else {
			retValue.put("status", 1);
			retValue.put("message", "DepartMentManager同意此次申请......");
		}
		
		if("0".equals(retValue.getString("status"))) return retValue;
		businessDealChain.doDealChain(businessInfo);
		return retValue;
	}

}
