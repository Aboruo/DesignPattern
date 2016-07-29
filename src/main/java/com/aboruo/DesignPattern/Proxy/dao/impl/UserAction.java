package com.aboruo.DesignPattern.Proxy.dao.impl;
import com.aboruo.DesignPattern.Proxy.dao.UserActionDao;
/**
 * 类名称：UserAction
 * 类描述：用户业务操作类，实现了用户业务操作接口
 * @author aboruo
 * @date 2016年7月29日 上午10:32:39
 */
public class UserAction implements UserActionDao {
	@Override
	public void userOpenFile(String fileName) {
		System.out.println("用户打开文件===" + fileName);
	}
}
