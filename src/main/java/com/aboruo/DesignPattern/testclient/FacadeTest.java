package com.aboruo.DesignPattern.testclient;
import com.aboruo.DesignPattern.Facade.ComputerFacade;
/**
 * 类名称：FacadeTest
 * 类描述：Facade设计模式测试类
 * @author aboruo
 * @date 2016年7月29日 下午3:00:54
 */
public class FacadeTest {

	public static void main(String[] args) {
		System.out.println("user play games soft");
		ComputerFacade computerFacade = new ComputerFacade();
		computerFacade.startUp();
	}
}
