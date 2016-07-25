package com.aboruo.DesignPattern.Proxy.dao.impl;

import com.aboruo.DesignPattern.Proxy.dao.UserActionDao;

public class UserAction implements UserActionDao {
	@Override
	public void userOpenFile(String fileName) {
		System.out.println("用户打开文件===" + fileName);
	}

}
