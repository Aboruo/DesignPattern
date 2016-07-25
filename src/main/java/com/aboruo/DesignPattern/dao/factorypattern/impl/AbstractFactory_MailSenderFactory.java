package com.aboruo.DesignPattern.dao.factorypattern.impl;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.dao.factorypattern.SenderProvider;
/**
 * 类名称：AbstractFactory_MailSenderFactory
 * 类描述：抽象工厂模式，MailSender工厂类，用来生成CommonMailSender对象
 * @author aboruo
 * @date 2016年7月21日 下午3:45:38
 */
public class AbstractFactory_MailSenderFactory implements SenderProvider {

	@Override
	public CommonSender produce() {
		return new CommonMailSender();
	}

}
