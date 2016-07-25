package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.dao.factorypattern.SenderProvider;
import com.aboruo.DesignPattern.dao.factorypattern.impl.AbstractFactory_MailSenderFactory;
import com.aboruo.DesignPattern.dao.factorypattern.impl.AbstractFactory_SmsSenderFactory;
/**
 * 类名称：AbstractFactoryTest
 * 类描述：抽象工厂模式测试类
 * @author aboruo
 * @date 2016年7月21日 下午3:44:23
 */
public class AbstractFactoryTest {
	public static void main(String[] args) {
		SenderProvider senderProvider = null;
		/** 1 给senderProvider注入 AbstractFactory_MailSenderFactory */
		senderProvider = new AbstractFactory_MailSenderFactory();
		CommonSender commonSender = senderProvider.produce(); //生成的是MailSender对象
		commonSender.send(); //执行CommonMailSender的send动作
		
		/** 2 给senderProvider注入 AbstractFactory_SmsSenderFactory */
		senderProvider = new AbstractFactory_SmsSenderFactory();
		commonSender = senderProvider.produce(); //生成的是SmsSender对象
		commonSender.send(); //执行CommonSmsSender的send动作
	}

}
