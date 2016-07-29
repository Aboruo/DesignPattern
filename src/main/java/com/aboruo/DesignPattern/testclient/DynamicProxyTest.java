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
		UserAction userAction = new UserAction();
		//设置此系统属性,以查看代理类文件，可以生成代理类文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		UserActionProxyHandler userActionProxyHandler = new UserActionProxyHandler();
		userActionProxyHandler.setUserActionDao(userAction);
		/** proxy生成代理对象 */
		UserActionDao proxyUserAction = (UserActionDao) Proxy.newProxyInstance(UserActionDao.class.getClassLoader(),new Class[]{UserActionDao.class}, userActionProxyHandler);
		proxyUserAction.userOpenFile("testFile.txt");
	}

}
