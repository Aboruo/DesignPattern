package com.aboruo.DesignPattern.Facade;
/**
 * 类名称：Disk
 * 类描述：硬盘
 * @author aboruo
 * @date 2016年7月29日 下午2:59:25
 */
public class Disk {
	public int provideDiskStorage(){
		System.out.println("I'm Disk and i provide so much space......");
		return 20148;
	}
}
