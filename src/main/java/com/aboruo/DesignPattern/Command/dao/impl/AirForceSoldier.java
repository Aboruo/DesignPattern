package com.aboruo.DesignPattern.Command.dao.impl;

import com.aboruo.DesignPattern.Command.dao.Receiver;

public class AirForceSoldier implements Receiver {

	@Override
	public void executeCommand() {
		System.out.println("空军飞行员正在执行命令");
	}

}
