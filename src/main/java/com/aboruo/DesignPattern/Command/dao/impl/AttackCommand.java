package com.aboruo.DesignPattern.Command.dao.impl;

import com.aboruo.DesignPattern.Command.dao.Command;
import com.aboruo.DesignPattern.Command.dao.Receiver;
/**
 * 类名称：AttackCommand
 * 类描述：命令模式-- 命令接口实现：攻击命令
 * @author aboruo
 * @date 2017年3月28日 下午5:50:35
 */
public class AttackCommand implements Command {
	private Receiver receiver;
	public AttackCommand(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		System.out.println("攻击命令发布");
		receiver.executeCommand();
	}

}
