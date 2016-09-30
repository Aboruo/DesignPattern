package com.aboruo.DesignPattern.iterator.dao;

public interface Collection<T> {
	public Iterator<T> iterator();
	public void add(T t);
	public T get(int index);
	public void remove(T t);
	public int size();
}
