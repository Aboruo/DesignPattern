package com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Car;
import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Road;
/**
 * 类名称：CarRunOnRoad
 * 类描述：表示汽车在公路上跑 类
 * @author aboruo
 * @date 2016年7月29日 下午6:01:45
 */
public class CarRunOnRoad {
	private Car car;
	private Road road;
	public void carRun(){
		System.out.println(this.car.run() + this.road.showRoad());
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Road getRoad() {
		return road;
	}
	public void setRoad(Road road) {
		this.road = road;
	}
}
