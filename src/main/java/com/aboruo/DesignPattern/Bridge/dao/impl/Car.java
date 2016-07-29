package com.aboruo.DesignPattern.Bridge.dao.impl;

import com.aboruo.DesignPattern.Bridge.dao.Moveable;
/**
 * 类名称：Car
 * 类描述：小汽车类
 * @author aboruo
 * @date 2016年7月29日 下午5:59:55
 */
public class Car implements Moveable {
	@Override
	public String run() {
		return "小汽车在";
	}

}
