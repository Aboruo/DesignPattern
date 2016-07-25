package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.factory.CommonSenderFactoryMultiMethod;
public class CommonFactoryMultiMethodTest {

	public static void main(String[] args) {
		CommonSender commonSender = CommonSenderFactoryMultiMethod.produceMailSender();
		commonSender.send();
		commonSender = CommonSenderFactoryMultiMethod.produceSmsSender();
		commonSender.send();
	}

}
