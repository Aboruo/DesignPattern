package com.aboruo.DesignPattern.TemplateMethod.abstracts.impl;

import java.util.Map;

import com.aboruo.DesignPattern.TemplateMethod.abstracts.PeopleGetRewardsServiceAbs;
import com.alibaba.fastjson.JSONObject;

public class PeopleGetRewardsServiceImpl extends PeopleGetRewardsServiceAbs {

	@Override
	public Map<String, Object> analysisParam(Map<String, Object> map) {
		System.out.println("PeopleGetRewardsServiceImpl开始解析service上层传递过来的参数....");
		System.out.println("PeopleGetRewardsServiceImpl解析service上层传递过来的参数完成....");
		return map;
	}

	@Override
	public JSONObject checkEnoughRewardsToDistribute(Map<String, Object> map) {
		JSONObject retValue = new JSONObject();
		retValue.put("status", 1);
		retValue.put("message", "计算完成");
		return retValue;
	}

	@Override
	public JSONObject decreasePlatFormRewardsNums(Map<String, Object> map) {
		JSONObject retValue = new JSONObject();
		retValue.put("status", 1);
		retValue.put("message", "计算完成");
		System.out.println("平台奖品剩余分发数量核减完成");
		return retValue;
	}
	/**
	 * @Title:ifDecreasePlatFormRewardsNums
	 * @Description:钩子方法，是否需要减少平台奖品剩余数量，根据具体业务实现来重写
	 * 该钩子方法，默认返回false
	 * @author:aboruo
	 * @param map
	 * @return boolean
	 * @date 2016年9月18日 上午1:15:02
	 */
	public  boolean ifDecreasePlatFormRewardsNums(Map<String, Object> map){
		return true;
	}
}
