package com.aboruo.DesignPattern.Adapter.dao.impl;

import com.aboruo.DesignPattern.Adapter.dao.AdapterTargetable;
import com.aboruo.DesignPattern.Adapter.entity.Source;
/**
 * 类名称：Adapter
 * 类描述：类适配器模式  适应新需求的新适配器类
 * 既有原有的方法，也有新需求所要求的方法
 * @author aboruo
 * @date 2016年7月22日 下午4:35:03
 */
public class Adapter extends Source implements AdapterTargetable {

	@Override
	public void needNewMethod() {
		System.out.println("类适配器模式=====>yes ! this is our extra need method");
	}

}
