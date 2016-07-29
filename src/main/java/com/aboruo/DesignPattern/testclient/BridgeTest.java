package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Bridge.abstraBridge.CarToRoadBridge;
import com.aboruo.DesignPattern.Bridge.abstraBridge.impl.CarToRoadBridgeImpl;
import com.aboruo.DesignPattern.Bridge.dao.Moveable;
import com.aboruo.DesignPattern.Bridge.dao.Roadable;
import com.aboruo.DesignPattern.Bridge.dao.impl.Bus;
import com.aboruo.DesignPattern.Bridge.dao.impl.Car;
import com.aboruo.DesignPattern.Bridge.dao.impl.SpeedWay;
import com.aboruo.DesignPattern.Bridge.dao.impl.Street;
/**
 * 类名称：BridgeTest
 * 类描述：桥接模式测试类
 * @author aboruo
 * @date 2016年7月29日 下午5:57:34
 */
public class BridgeTest {
	public static void main(String[] args){
		Roadable road = new SpeedWay();
		CarToRoadBridge carToRoadBridge = new CarToRoadBridgeImpl();
		carToRoadBridge.setRoad(road);
		Moveable car = new Bus();
		System.out.println(car.run() + carToRoadBridge.showName());
		
		car = new Car();
		road = new Street();
		carToRoadBridge.setRoad(road);
		System.out.println(car.run() + carToRoadBridge.showName());
	}
}
