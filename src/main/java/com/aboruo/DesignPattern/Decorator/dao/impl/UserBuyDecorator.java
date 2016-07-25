package com.aboruo.DesignPattern.Decorator.dao.impl;

import java.util.Map;

import com.aboruo.DesignPattern.Decorator.dao.DecoratorUserDao;

public class UserBuyDecorator implements DecoratorUserDao {
	private DecoratorUserDao userBuy;
	public UserBuyDecorator(){}
	public UserBuyDecorator(DecoratorUserDao userBuy){
		this.userBuy = userBuy;
	}
	public DecoratorUserDao getUserBuy() {
		return userBuy;
	}
	public void setUserBuy(UserBuy userBuy) {
		this.userBuy = userBuy;
	}
	@Override
	public void userBuy(Map<String, Object> map) {
		System.out.println("购买产品前校验用户是否登陆......");
		userBuy.userBuy(map);
		System.out.println("记录用户购买产品日志");
	}

}
