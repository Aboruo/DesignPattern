package com.aboruo.DesignPattern.Strategy.dao;
/**
 * 类名称：Comparator
 * 类描述：比较策略，比较器
 * @author aboruo
 * @date 2016年8月8日 下午4:13:51
 * @param <T>
 */
public interface Comparator<T> {
	public int compare(T o1,T o2);
}