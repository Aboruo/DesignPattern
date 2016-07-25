package com.aboruo.DesignPattern.dao.factorypattern;
/**
 * 类名称：SenderProvider
 * 类描述：2 抽象工厂模式，各个senderfactory都要
 * 实现此接口，用来生成相应的sender对象，例如：
 * AbstractFactory_MailSenderFactory 的 produce 
 * 生成CommonMailSender对象
 * @author aboruo
 * @date 2016年7月21日 下午3:50:23
 */
public interface SenderProvider {
	public CommonSender produce();
}
