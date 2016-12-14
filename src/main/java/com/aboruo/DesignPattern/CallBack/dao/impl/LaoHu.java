package com.aboruo.DesignPattern.CallBack.dao.impl;

import com.aboruo.DesignPattern.CallBack.dao.CallBack;

public class LaoHu {
	private String name;
	public LaoHu(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void giveMeSomeGifPic(CallBack callBack,String msg){
		try {
			System.out.println(msg);
			Thread.sleep(1000 * 2);
			System.out.println("哦哦。。。我擦！我胡某人正在浇灌祖国的花骨朵呢......等我上完课就给你");
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		callBack.giveYouSomeGifPic("给。。。你要的岛国小报刊。。。看去吧。。。不够了我还有1T呢。。。");
	}
}
