package com.aboruo.DesignPattern.Bridge.dao.impl;

import com.aboruo.DesignPattern.Bridge.dao.Roadable;

public class SpeedWay implements Roadable {
	@Override
	public String showName() {
		return "高速公路上";
	}
}
