package com.aboruo.DesignPattern.testclient;

import java.io.IOException;

import com.aboruo.DesignPattern.Prototype.Prototype;

/**
 * 类名称：PrototypeTest
 * 类描述：原型设计模式测试类
 * @author aboruo
 * @date 2016年7月21日 下午6:16:51
 */
public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Prototype prototype = new Prototype("prototype test", 12);
		/** 浅复制，可以看到Prototype的引用类型的成员变量，并没有进行复制，
		 * 两个对象的引用类型成员变量指向都是同一个内存空间
		 * 基础类型数据会进行复制 */
		Prototype prototype2 = (Prototype) prototype.clone();
		System.out.println(prototype == prototype2);
		System.out.println(prototype.getNum() == prototype2.getNum());
		System.out.println(prototype.getTestStr() == prototype2.getTestStr());
		
		/** 深度复制，可以看到Prototype的引用类型的成员变量已进行了复制，
		 * 两个对象的引用类型成员变量指向各自不同的内存空间
		 * 基础类型数据会进行复制 */
		prototype2 = (Prototype) prototype.deepClone();
		System.out.println(prototype == prototype2);
		System.out.println(prototype.getNum() == prototype2.getNum());
		System.out.println(prototype.getTestStr() == prototype2.getTestStr());
	}

}
