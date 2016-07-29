package com.aboruo.DesignPattern.Bridge.dao.impl;

import com.aboruo.DesignPattern.Bridge.dao.Moveable;
/**
 * 类名称：Bus
 * 类描述：公共汽车类
 * @author aboruo
 * @date 2016年7月29日 下午5:59:33
 */
public class Bus implements Moveable {
	@Override
	public String run() {
		return "公共汽车行驶在";
	}

}
