package com.aboruo.DesignPattern.iterator.dao;
/**
 * 类名称：Iterator
 * 类描述：迭代器接口
 * @author aboruo
 * @date 2016年9月28日 上午11:10:00
 * @param <T>
 */
public interface Iterator<T> {
	public boolean hasNext();
	public T next();
	public T first();
	public T previous();
	public boolean remove();
}
