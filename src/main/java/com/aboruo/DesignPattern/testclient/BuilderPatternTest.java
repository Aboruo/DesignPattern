package com.aboruo.DesignPattern.testclient;

import java.util.Iterator;
import java.util.List;

import com.aboruo.DesignPattern.Builder.Builder;
import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
/**
 * 类名称：BuilderPatternTest
 * 类描述：建造模式测试类
 * @author aboruo
 * @date 2016年7月21日 下午5:32:45
 */
public class BuilderPatternTest {

	public static void main(String[] args) {
		Builder builder = Builder.build();
		/** 1 构造20个MailSender对象 */
		List<CommonSender> senderList = builder.produceMailSender(20).getSenderList();
		CommonSender commonSender = null;
		for(Iterator<CommonSender> iterator = senderList.iterator();iterator.hasNext();){
			commonSender = iterator.next();
			commonSender.send();
		}
	}

}
