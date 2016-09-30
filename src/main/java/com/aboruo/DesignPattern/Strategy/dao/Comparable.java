package com.aboruo.DesignPattern.Strategy.dao;
/**
 * 类名称：Comparable
 * 类描述：策略模式，实现该接口的类，都具有可比较的行为
 * @author aboruo
 * @date 2016年8月8日 下午4:14:11
 * @param <T>
 */
public interface Comparable<T> {
	public int compareTo(T o);
}