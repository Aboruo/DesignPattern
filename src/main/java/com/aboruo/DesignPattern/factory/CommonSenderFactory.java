package com.aboruo.DesignPattern.factory;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonMailSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonSmsSender;
/**
 * 类名称：CommonSenderFactory
 * 类描述：普通工厂模式，单个工厂方法
 * @author aboruo
 * @date 2016年7月21日 下午3:19:33
 */
public class CommonSenderFactory {
	public static CommonSender product(String senderType){
		if("mail".equals(senderType)){
			return new CommonMailSender();
		}else if ("sms".equals(senderType)) {
			return new CommonSmsSender();
		}else {
			System.out.println("please input the correct senderType");
			return null;
		}
	}
}
