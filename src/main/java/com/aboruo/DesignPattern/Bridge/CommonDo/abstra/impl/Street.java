package com.aboruo.DesignPattern.Bridge.CommonDo.abstra.impl;

import com.aboruo.DesignPattern.Bridge.CommonDo.abstra.Road;
/**
 * 类名称：Street
 * 类描述：传统模式，街道 路类型
 * @author aboruo
 * @date 2016年7月29日 下午6:03:15
 */
public class Street extends Road {
	@Override
	public String showRoad() {
		return "街道上......";
	}
}
