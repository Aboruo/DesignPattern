package com.aboruo.DesignPattern.factory;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonMailSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonSmsSender;
/**
 * 类名称：CommonSenderFactory
 * 类描述：普通工厂模式，每种类型对应一个生产方法
 * @author aboruo
 * @date 2016年7月21日 下午3:19:33
 */
public class CommonSenderFactoryMultiMethod {
	/**
	 * @Title:productMailSender
	 * @Description:生成email发送对象
	 * @author:aboruo
	 * @return CommonSender
	 * @date 2016年7月21日 下午3:22:48
	 */
	public static CommonSender produceMailSender(){
		return new CommonMailSender();
	}
	/**
	 * @Title:produceSmsSender
	 * @Description:生成sms短信发送sender对象
	 * @author:aboruo
	 * @return CommonSender
	 * @date 2016年7月21日 下午3:23:48
	 */
	public static CommonSender produceSmsSender(){
		return new CommonSmsSender();
	}
}
