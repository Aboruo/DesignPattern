package com.aboruo.DesignPattern.Facade;
/**
 * 类名称：MemeryCache
 * 类描述：内存
 * @author aboruo
 * @date 2016年7月29日 下午2:59:02
 */
public class MemeryCache {
	public int provideMemeryStorage(){
		System.out.println("I'm MemeryCache and i provide so much space......");
		return 1024;
	}
	public void needDiskStorage(){
		System.out.println("i'm memery ,and i need enough disk storage");
	}
}
