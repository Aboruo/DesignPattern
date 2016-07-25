package com.aboruo.DesignPattern.dao.factorypattern.impl;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;

public class CommonMailSender implements CommonSender {

	@Override
	public void send() {
		System.out.println("CommonMailSender send email");
	}

}
