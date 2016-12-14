/**
 * AbstractMonitored.java
 * com.aboruo.DesignPattern.Observer.dao.abs
 * @description:TODO
 * @author : aboruo
 * @date 2016年10月8日 下午6:40:20
 */
package com.aboruo.DesignPattern.Observer.dao.abs;

import java.util.Enumeration;
import java.util.Vector;

import com.aboruo.DesignPattern.Observer.dao.Monitored;
import com.aboruo.DesignPattern.Observer.dao.Observer;

/**
 * 类名称：AbstractMonitored
 * 类描述：TODO
 * @author aboruo
 * @date 2016年10月8日 下午6:40:20
 */
public abstract class AbstractMonitored implements Monitored {
	private Vector<Observer> vector = new Vector<Observer>();
	
	/**
	 * @Title:add
	 * @Description:添加观察者
	 * @author:aboruo
	 * @param observer void
	 * @date 2016年10月8日 下午6:32:17
	 */
	@Override
	public void add(Observer observer) {
		vector.add(observer);
	}
	/**
	 * @Title:remove
	 * @Description:删除观察者
	 * @author:aboruo
	 * @param observer void
	 * @date 2016年10月8日 下午6:32:54
	 */
	@Override
	public void remove(Observer observer) {
		vector.removeElement(observer);
	}
	/**
	 * @Title:notifyObservers
	 * @Description:通知所有观察者
	 * @author:aboruo void
	 * @date 2016年10月8日 下午6:34:19
	 */
	@Override
	public void notifyObservers() {
		Enumeration<Observer> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			Observer observer =  enumeration.nextElement();
			observer.update();
		}
	}
}
