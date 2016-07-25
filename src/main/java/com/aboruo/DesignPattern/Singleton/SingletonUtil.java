package com.aboruo.DesignPattern.Singleton;
/**
 * 类名称：SingletonUtil
 * 类描述：Singleton设计模式 单例类
 * please refference the doc
 * @author aboruo
 * @date 2016年7月21日 下午4:16:13
 */
public class SingletonUtil {
	private static SingletonUtil singletonUtil;
	/** 私有化构造方法，使得该类不能在类外面进行实例化 */
	private SingletonUtil(){}
	
	/**
	 * @Title:getInstance
	 * @Description:SingletonUtil的单例方法
	 * @author:aboruo
	 * @return SingletonUtil
	 * @date 2016年7月21日 下午4:14:25
	 */
	public static SingletonUtil getInstance(){
		if (singletonUtil == null) {
			syncInstance();
		}
		return singletonUtil;
	}
	/**
	 * @Title:syncInstance
	 * @Description:线程同步获得单例对象
	 * @author:aboruo void
	 * @date 2016年7月21日 下午4:19:31
	 */
	private static synchronized void syncInstance(){
		if (singletonUtil == null) {
			singletonUtil = new SingletonUtil();
		}
	}
	public void showMessage(){
		System.out.println("获得单例测试");
	}
}
