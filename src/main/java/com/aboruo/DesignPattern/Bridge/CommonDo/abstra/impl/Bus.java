package com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Car;

public class Bus extends Car {
	@Override
	public String run() {
		return "小汽车跑在";
	}

}
