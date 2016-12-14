package com.aboruo.DesignPattern.Observer.dao.impl;

import com.aboruo.DesignPattern.Observer.dao.Observer;

public class ObserverB implements Observer {

	@Override
	public void update() {
		System.out.println("ObserverB has received your message");
	}
}
