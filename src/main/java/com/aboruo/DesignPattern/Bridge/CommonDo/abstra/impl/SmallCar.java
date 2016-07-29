package com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Car;
/**
 * 类名称：SmallCar
 * 类描述：传统模式，小汽车类
 * @author aboruo
 * @date 2016年7月29日 下午6:02:14
 */
public class SmallCar extends Car {
	@Override
	public String run() {
		return "小汽车跑在";
	}
}
