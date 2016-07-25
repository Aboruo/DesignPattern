package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.factory.CommonSenderFactory;

public class CommonFactoryTest {

	public static void main(String[] args) {
		CommonSender commonSender = CommonSenderFactory.product("mail");
		commonSender.send();
		commonSender = CommonSenderFactory.product("sms");
		commonSender.send();
	}

}
