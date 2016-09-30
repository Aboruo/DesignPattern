package com.aboruo.DesignPattern.Strategy.dao.impl;

import com.aboruo.DesignPattern.Strategy.dao.Comparator;
/**
 * 类名称：RectangleComparator
 * 类描述：比较策略，矩形比较器(矩形的一种比较策略，比较面积)
 * @author aboruo
 * @date 2016年8月8日 下午4:09:56
 */
public class RectangleComparator implements Comparator<Rectangle> {
	@Override
	public int compare(Rectangle o1,Rectangle o2) {
		return o1.getLength() * o1.getWidth() - o2.getLength() * o2.getWidth();
	}

}
