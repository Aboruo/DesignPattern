package com.aboruo.DesignPattern.Observer.dao;
/**
 * 类名称：Monitored
 * 类描述：被监视者接口，
 * 所有需要被监视的对象都应实现该接口
 * @author aboruo
 * @date 2016年10月8日 下午6:26:00
 */
public interface Monitored {
	/**
	 * @Title:add
	 * @Description:添加观察者
	 * @author:aboruo
	 * @param observer void
	 * @date 2016年10月8日 下午6:32:17
	 */
	public void add(Observer observer);
	/**
	 * @Title:remove
	 * @Description:删除观察者
	 * @author:aboruo
	 * @param observer void
	 * @date 2016年10月8日 下午6:32:54
	 */
	public void remove(Observer observer);
	/**
	 * @Title:notifyObservers
	 * @Description:通知所有观察者
	 * @author:aboruo void
	 * @date 2016年10月8日 下午6:34:19
	 */
	public void notifyObservers();
	/**
	 * @Title:operate
	 * @Description:做一些操作
	 * @author:aboruo void
	 * @date 2016年10月8日 下午6:48:23
	 */
	public void operate();
}
