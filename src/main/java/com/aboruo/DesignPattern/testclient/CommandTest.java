package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Command.dao.Command;
import com.aboruo.DesignPattern.Command.dao.Receiver;
import com.aboruo.DesignPattern.Command.dao.impl.AirForceSoldier;
import com.aboruo.DesignPattern.Command.dao.impl.AttackCommand;
import com.aboruo.DesignPattern.Command.dao.impl.Invoker;
/**
 * 类名称：CommandTest
 * 类描述：命令模式--测试类
 * @author aboruo
 * @date 2017年3月28日 下午5:58:59
 */
public class CommandTest {

	public static void main(String[] args) {
		Receiver receiver = new AirForceSoldier();
		Command command = new AttackCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.giveCommand();
	}

}
