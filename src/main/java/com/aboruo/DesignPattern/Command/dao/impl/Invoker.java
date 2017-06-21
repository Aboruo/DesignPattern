package com.aboruo.DesignPattern.Command.dao.impl;

import com.aboruo.DesignPattern.Command.dao.Command;
/**
 * 类名称：Invoker
 * 类描述：命令模式--下达命令者：如司令员
 * @author aboruo
 * @date 2017年3月28日 下午5:54:40
 */
public class Invoker {
	private Command command;
	public Invoker(Command command){
		this.command = command;
	}
	public void giveCommand(){
		System.out.println("司令员正在下达命令......");
		this.command.execute();
	}
}
