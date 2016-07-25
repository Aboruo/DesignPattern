package com.aboruo.DesignPattern.Adapter.dao.impl;

public class SourceSub2 extends InterfaceAdapterAbstract {
	@Override
	public void useKeyboard(){
		System.out.println("接口适配器模式====>我只使用键盘");
	}
}
