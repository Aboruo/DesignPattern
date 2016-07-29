package com.aboruo.DesignPattern.Bridge.abstraBridge;

import com.aboruo.DesignPattern.Bridge.dao.Roadable;
/**
 * 类名称：CarToRoadBridge
 * 类描述：汽车到路的桥接类
 * @author aboruo
 * @date 2016年7月29日 下午5:58:40
 */
public abstract class CarToRoadBridge {
	protected Roadable road;
	public Roadable getRoad() {
		return road;
	}
	public void setRoad(Roadable road) {
		this.road = road;
	}
	public abstract String showName();
}
