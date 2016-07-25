package com.aboruo.DesignPattern.Builder;

import java.util.ArrayList;
import java.util.List;

import com.aboruo.DesignPattern.dao.factorypattern.CommonSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonMailSender;
import com.aboruo.DesignPattern.dao.factorypattern.impl.CommonSmsSender;
/**
 * 类名称：Builder
 * 类描述：建造者模式（Builder）
 * @author aboruo
 * @date 2016年7月21日 下午5:23:29
 */
public class Builder {
	private List<CommonSender> senderList = new ArrayList<CommonSender>();
	public List<CommonSender> getSenderList() {
		return senderList;
	}
	public void setSenderList(List<CommonSender> senderList) {
		this.senderList = senderList;
	}
	public Builder produceMailSender(int senderNums){
		for (int i = 0; i < senderNums; i++) {
			senderList.add(new CommonMailSender());
		}
		System.out.println("所有的MailSender对象初始化完成");
		return this;
	}
	public Builder produceSmsSender(int senderNums){
		for(int j = 0; j < senderNums; j++){
			senderList.add(new CommonSmsSender());
		}
		System.out.println("所有的SmsSender对象初始化完成");
		return this;
	}
	/** 私有化构造方法 */
	private Builder(){}
	public static Builder build(){
		return new Builder();
	}
}
