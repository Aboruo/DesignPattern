package com.aboruo.DesignPattern.Observer.dao.impl;

import com.aboruo.DesignPattern.Observer.dao.Observer;

public class ObserverA implements Observer {

	@Override
	public void update() {
		System.out.println("ObserverA has received your message");
	}
}
