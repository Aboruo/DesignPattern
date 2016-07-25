package com.aboruo.DesignPattern.Proxy.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import com.aboruo.DesignPattern.Proxy.dao.UserActionDao;
/**
 * 类名称：UserActionProxyHandler
 * 类描述：用户行为代理类
 * @author aboruo
 * @date 2016年7月25日 下午6:38:20
 */
public class UserActionProxyHandler implements InvocationHandler{
	private UserActionDao userActionDao;
	public UserActionDao getUserActionDao() {
		return userActionDao;
	}
	public void setUserActionDao(UserActionDao userActionDao) {
		this.userActionDao = userActionDao;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeDo();
		method.invoke(userActionDao, args);
		afterDo();
		return null;
	}
	private void beforeDo(){
		System.out.println("检查用户是否有权限进行此操作......");
	}
	private void afterDo(){
		System.out.println("记录用户行为操作记录");
	}
}
