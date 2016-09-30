package com.aboruo.DesignPattern.Strategy.dao.impl;

import com.aboruo.DesignPattern.Strategy.dao.Comparable;
import com.aboruo.DesignPattern.Strategy.dao.Comparator;

public class Rectangle implements Comparable<Rectangle> {
	private int length;
	private int width;
	private Comparator<Rectangle> comparator;
	
	public Rectangle(){}
	public Rectangle(int length,int width,Comparator<Rectangle> comparator){
		this.length=length;
		this.width=width;
		this.comparator = comparator;
	}
	public Comparator<Rectangle> getComparator() {
		return comparator;
	}
	public void setComparator(Comparator<Rectangle> comparator) {
		this.comparator = comparator;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public int compareTo(Rectangle o) {
		int result = comparator.compare(this,o);
		result = result > 0 ? 1 :(result < 0 ? -1 : 0);
		return result;
	}

}
