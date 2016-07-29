package com.aboruo.DesignPattern.Bridge.dao.impl;

import com.aboruo.DesignPattern.Bridge.dao.Roadable;

public class Street implements Roadable {

	@Override
	public String showName() {
		return "街道上......";
	}
}
