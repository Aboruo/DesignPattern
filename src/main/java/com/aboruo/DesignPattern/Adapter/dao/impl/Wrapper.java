package com.aboruo.DesignPattern.Adapter.dao.impl;

import com.aboruo.DesignPattern.Adapter.dao.AdapterTargetable;
import com.aboruo.DesignPattern.Adapter.entity.Source;
/**
 * 类名称：Wrapper
 * 类描述：对象的适配器模式 
 * 基本思路和类的适配器模式相同，
 * 只是将Adapter类作修改，这次不继承Source类，
 * 而是持有Source类的实例，以达到解决兼容性的问题
 * @author aboruo
 * @date 2016年7月22日 下午4:58:25
 */
public class Wrapper implements AdapterTargetable {
	private Source source;
	
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Wrapper() {
	}
	public Wrapper(Source source){
		super();
		this.source = source;
	}
	@Override
	public void originalMethod() {
		source.originalMethod();
	}

	@Override
	public void needNewMethod() {
		System.out.println("对象的适配器模式====>适配新需求中的新方法");
	}

}
