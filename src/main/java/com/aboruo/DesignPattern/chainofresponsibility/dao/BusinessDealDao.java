package com.aboruo.DesignPattern.chainofresponsibility.dao;

import java.util.Map;
import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.alibaba.fastjson.JSONObject;

public interface BusinessDealDao {
	public JSONObject doDeal(Map<String, Object> businessInfo,BusinessDealChain businessDealChain);
}
