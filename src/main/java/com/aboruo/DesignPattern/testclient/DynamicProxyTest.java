package com.aboruo.DesignPattern.testclient;

import java.lang.reflect.Proxy;

import com.aboruo.DesignPattern.Proxy.dao.UserActionDao;
import com.aboruo.DesignPattern.Proxy.dao.impl.UserAction;
import com.aboruo.DesignPattern.Proxy.dao.impl.UserActionProxyHandler;

/**
 * 类名称：DynamicProxyTest
 * 类描述：动态代理测试类
 * @author aboruo
 * @date 2016年7月25日 下午6:18:45
 */
public class DynamicProxyTest {

	public static void main(String[] args) {
		UserActionDao userActionDao = new UserAction();
		UserActionProxyHandler userActionProxyHandler = new UserActionProxyHandler();
		userActionProxyHandler.setUserActionDao(userActionDao);
		UserActionDao proxyUserAction = (UserActionDao) Proxy.newProxyInstance(UserActionDao.class.getClassLoader(),new Class[]{UserActionDao.class}, userActionProxyHandler);
		proxyUserAction.userOpenFile("testFile.txt");
	}

}
