package com.aboruo.DesignPattern.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 类名称：Prototype
 * 类描述：原型设计模式，分了：浅复制 和 深度复制两种模式
 * @author aboruo
 * @date 2016年7月21日 下午6:15:45
 */
public class Prototype implements Serializable,Cloneable{

	/**
	 * Prototype 的serialId
	 */
	private static final long serialVersionUID = 4649680042406027158L;
	private String testStr;
	private int num;
	public Prototype(String testStr,int num){
		this.testStr = testStr;
		this.num = num;
	}
	public Prototype(){}
	/** 浅复制 
	 * @throws CloneNotSupportedException */
	public Object clone() throws CloneNotSupportedException{
		return (Prototype) super.clone();
	}
	
	/** 深度复制 
	 * @throws IOException 
	 * @throws ClassNotFoundException */
	public Object deepClone() throws IOException, ClassNotFoundException{
		Object object = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		/** 将当前对象写入内存中,相当于在内存中另开辟一块空间,将当前对象复制到当前空间中 */
		bos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		/** 读取上一步新开辟的空间中的对象 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		object = ois.readObject();
		return object;
	}
	public String getTestStr() {
		return testStr;
	}
	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
