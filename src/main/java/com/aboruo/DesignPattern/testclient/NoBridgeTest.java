package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Car;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Road;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl.Bus;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl.CarRunOnRoad;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl.SmallCar;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl.SpeedWay;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl.Street;
/**
 * 类名称：NoBridgeTest
 * 类描述：与桥接模式相对应，这个类为改进型传统模式测试类
 * @author aboruo
 * @date 2016年7月29日 下午6:00:56
 */
public class NoBridgeTest {

	public static void main(String[] args) {
		Car car = null;
		Road road = null;
		
		car = new SmallCar();
		road = new SpeedWay();
		CarRunOnRoad carRunOnRoad = new CarRunOnRoad();
		carRunOnRoad.setCar(car);
		carRunOnRoad.setRoad(road);
		carRunOnRoad.carRun();
		
		car = new Bus();
		road = new Street();
		carRunOnRoad.setCar(car);
		carRunOnRoad.setRoad(road);
		carRunOnRoad.carRun();
	}

}
