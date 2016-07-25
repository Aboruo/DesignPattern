package com.aboruo.DesignPattern.Decorator.dao.impl;

import java.util.Map;

import com.aboruo.DesignPattern.Decorator.dao.DecoratorUserDao;

public class UserBuy implements DecoratorUserDao {

	@Override
	public void userBuy(Map<String, Object> map) {
		System.out.println("用户购买产品");
	}

}
