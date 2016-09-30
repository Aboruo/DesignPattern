package com.aboruo.DesignPattern.TemplateMethod.dao;

import java.util.Map;
import com.alibaba.fastjson.JSONObject;

public interface PeopleGetRewardsServiceDao {
	public JSONObject distributRewardsToUsers(Map<String,Object> map) throws Exception;
}
