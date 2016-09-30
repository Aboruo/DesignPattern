package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Strategy.dao.Comparator;
import com.aboruo.DesignPattern.Strategy.dao.impl.Rectangle;
import com.aboruo.DesignPattern.Strategy.dao.impl.RectangleComparator;
/**
 * 类名称：StrategyTestClient
 * 类描述：策略模式测试类
 * @author aboruo
 * @date 2016年8月8日 下午5:14:40
 */
public class StrategyTestClient {
	public static void main(String[] args){
		Comparator<Rectangle> comparator = new RectangleComparator();
		Rectangle r1 = new Rectangle(10, 5, comparator);
		Rectangle r2 = new Rectangle(10, 5, comparator);
		int result = r1.compareTo(r2);
		switch (result) {
		case 0:
			System.out.println("r1 与 r2 大小相等");
			break;
		case 1:
			System.out.println("r1 比 r2 大");
			break;
		case -1:
			System.out.println("r1 比 r2 小");
			break;
		default:
			break;
		}
	}
}
