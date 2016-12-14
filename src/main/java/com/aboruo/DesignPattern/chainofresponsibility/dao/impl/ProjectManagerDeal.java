package com.aboruo.DesignPattern.chainofresponsibility.dao.impl;

import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;
import com.alibaba.fastjson.JSONObject;

public class ProjectManagerDeal implements BusinessDealDao {

	/**
	 * 方法名称：doDeal
	 * 方法描述：项目经理处理业务请求
	 * @author aboruo
	 * @param businessInfo 业务信息参数
	 * @param businessDealChain 业务处理责任链
	 * @return JSONObject 返回处理结果
	 * @date 2016-10-09 16:41
	 */
	@Override
	public JSONObject doDeal(Map<String, Object> businessInfo,BusinessDealChain businessDealChain) {
		JSONObject retValue = new JSONObject();
		String userName = businessInfo.containsKey("userName") ? businessInfo.get("userName").toString() : "";
		String applyFundsStr = businessInfo.containsKey("applyFunds") ? businessInfo.get("applyFunds").toString() : "0.0";
		double applyFunds = Double.parseDouble(applyFundsStr);
		
		if("".equals(userName) || applyFunds <= 0 || applyFunds >= 10000){
			retValue.put("status", 0);
			retValue.put("message", "申请不符合条件......");
		}else {
			retValue.put("status", 1);
			retValue.put("message", "ProjectManager本人无意见，请上级领导批示......");
		}
		
		if("0".equals(retValue.getString("status"))) return retValue;
		businessDealChain.doDealChain(businessInfo);
		return retValue;
	}

}
