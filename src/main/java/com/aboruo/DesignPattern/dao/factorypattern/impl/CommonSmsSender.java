package com.aboruo.DesignPattern.dao.factorypattern.impl;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;

public class CommonSmsSender implements CommonSender {

	@Override
	public void send() {
		System.out.println("CommonSmsSender send short message");
	}

}
