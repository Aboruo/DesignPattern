package com.aboruo.DesignPattern.testclient;

import java.util.HashMap;
import java.util.Map;
import com.aboruo.DesignPattern.Decorator.dao.DecoratorUserDao;
import com.aboruo.DesignPattern.Decorator.dao.impl.UserBuy;
import com.aboruo.DesignPattern.Decorator.dao.impl.UserBuyDecorator;
/**
 * 类名称：DecoratorTest
 * 类描述：装饰模式测试类
 * @author aboruo
 * @date 2016年7月25日 下午5:33:01
 */
public class DecoratorTest {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Aboruo");
		/** 原功能类 */
		DecoratorUserDao userBuy = new UserBuy();
		userBuy.userBuy(map);
		System.out.println(System.lineSeparator()); //增加一行空行
		
		/** 在原来功能的基础上包装了新的功能 */
		DecoratorUserDao decoratorUserDao = new UserBuyDecorator(userBuy);
		decoratorUserDao.userBuy(map);
	}

}
