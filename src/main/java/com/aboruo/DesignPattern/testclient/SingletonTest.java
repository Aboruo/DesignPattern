package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Singleton.SingletonUtil;

public class SingletonTest {
	public static void main(String[] args){
		SingletonUtil singletonUtil = SingletonUtil.getInstance();
		singletonUtil.showMessage();
		SingletonUtil singletonUtil2 = SingletonUtil.getInstance();
		System.out.println(singletonUtil == singletonUtil2); //证明两个引用指向的是同一个对象
	}
}
