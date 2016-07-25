package com.aboruo.DesignPattern.Adapter.dao.impl;

public class SourceSub1 extends InterfaceAdapterAbstract {
	@Override
	public void useMouse(){
		System.out.println("接口适配器模式====>我只使用鼠标");
	}
}
