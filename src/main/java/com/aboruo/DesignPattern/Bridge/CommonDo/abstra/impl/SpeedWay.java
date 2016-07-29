package com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Road;
/**
 * 类名称：SpeedWay
 * 类描述：传统模式，高速公路 类
 * @author aboruo
 * @date 2016年7月29日 下午6:03:43
 */
public class SpeedWay extends Road {
	@Override
	public String showRoad() {
		return "高速公路上......";
	}
}
