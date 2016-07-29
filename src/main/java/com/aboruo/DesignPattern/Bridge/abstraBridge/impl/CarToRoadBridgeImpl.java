package com.aboruo.DesignPattern.Bridge.abstraBridge.impl;

import com.aboruo.DesignPattern.Bridge.abstraBridge.CarToRoadBridge;
/**
 * 类名称：CarToRoadBridgeImpl
 * 类描述：汽车到路的桥接实现类
 * @author aboruo
 * @date 2016年7月29日 下午5:57:54
 */
public class CarToRoadBridgeImpl extends CarToRoadBridge {
	@Override
	public String showName() {
		return road.showName();
	}
}
