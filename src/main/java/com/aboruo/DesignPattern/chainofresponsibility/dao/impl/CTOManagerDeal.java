package com.aboruo.DesignPattern.chainofresponsibility.dao.impl;

import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;
import com.alibaba.fastjson.JSONObject;

public class CTOManagerDeal implements BusinessDealDao {

	@Override
	public JSONObject doDeal(Map<String, Object> businessInfo, BusinessDealChain businessDealChain) {
		JSONObject retValue = new JSONObject();
		String userName = businessInfo.containsKey("userName") ? businessInfo.get("userName").toString() : "";
		String applyFundsStr = businessInfo.containsKey("applyFunds") ? businessInfo.get("applyFunds").toString() : "0.0";
		double applyFunds = Double.parseDouble(applyFundsStr);
		
		if("张三".equals(userName) || applyFunds <= 0 || applyFunds >= 10000){
			retValue.put("status", 0);
			retValue.put("message", "申请不符合条件......");
		}else {
			retValue.put("status", 1);
			retValue.put("message", "DepartMentManager本人无意见，请上级领导批示......");
		}
		
		if("0".equals(retValue.getString("status"))) return retValue;
		businessDealChain.doDealChain(businessInfo);
		return retValue;
	}

}
