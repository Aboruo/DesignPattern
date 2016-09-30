package com.aboruo.DesignPattern.testclient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.aboruo.DesignPattern.TemplateMethod.abstracts.PeopleGetRewardsServiceAbs;
import com.aboruo.DesignPattern.TemplateMethod.abstracts.impl.PeopleGetRewardsServiceImpl;

public class TemplateMethodTest {
	public static void main(String[] args){
		/** 1 创模板类 父类引用指向子类对象 */
		PeopleGetRewardsServiceAbs peopleGetRewardsServiceAbs = new PeopleGetRewardsServiceImpl();
		
		/** 2 组织业务参数并调用模板方法执行相关步骤操作 */
		Map<String,Object> map = new ConcurrentHashMap<String,Object>();
		map.put("platId", "0001");
		map.put("prizeId", "JL0001");
		try {
			peopleGetRewardsServiceAbs.distributRewardsToUsers(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
