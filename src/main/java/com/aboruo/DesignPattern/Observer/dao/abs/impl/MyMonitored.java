package com.aboruo.DesignPattern.Observer.dao.abs.impl;

import com.aboruo.DesignPattern.Observer.dao.abs.AbstractMonitored;

public class MyMonitored extends AbstractMonitored {

	@Override
	public void operate() {
		System.out.println("I will do some operation");
		notifyObservers();
	}

}
