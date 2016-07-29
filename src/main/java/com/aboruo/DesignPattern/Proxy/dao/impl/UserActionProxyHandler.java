package com.aboruo.DesignPattern.Proxy.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 类名称：UserActionProxyHandler
 * 类描述：用户行为代理类
 * @author aboruo
 * @date 2016年7月25日 下午6:38:20
 */
public class UserActionProxyHandler implements InvocationHandler{
	private UserAction userAction;
	public UserAction getUserActionDao() {
		return userAction;
	}
	public void setUserActionDao(UserAction userAction) {
		this.userAction = userAction;
	}
	/**
	 * 代理类核心方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeDo();
		Object retvalue = method.invoke(userAction, args);
		afterDo();
		return retvalue;
	}
	/**
	 * @Title:beforeDo
	 * @Description:代理类增加的检查操作
	 * @author:aboruo void
	 * @date 2016年7月29日 上午10:33:33
	 */
	private void beforeDo(){
		System.out.println("检查用户是否有权限进行此操作......");
	}
	/**
	 * @Title:afterDo
	 * @Description:代理类增加的日志记录操作
	 * @author:aboruo void
	 * @date 2016年7月29日 上午10:34:04
	 */
	private void afterDo(){
		System.out.println("记录用户行为操作记录");
	}
}
