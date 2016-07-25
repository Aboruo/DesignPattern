package com.aboruo.DesignPattern.Adapter.dao.impl;

import com.aboruo.DesignPattern.Adapter.dao.Sourceable;
/**
 * 类名称：InterfaceAdapterAbstract
 * 类描述：实现了  接口适配器模式接口 的抽象类
 * @author aboruo
 * @date 2016年7月22日 下午5:45:41
 */
public abstract class InterfaceAdapterAbstract implements Sourceable {
	public void useMouse(){}
	public void useKeyboard(){}
	public void useScreen(){}
}
