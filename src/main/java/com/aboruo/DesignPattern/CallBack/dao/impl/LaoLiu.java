package com.aboruo.DesignPattern.CallBack.dao.impl;

import com.aboruo.DesignPattern.CallBack.dao.CallBack;

public class LaoLiu implements CallBack {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private LaoHu laohu;
	public LaoHu getLaohu() {
		return laohu;
	}
	public void setLaohu(LaoHu laohu) {
		this.laohu = laohu;
	}
	public LaoLiu(String name,LaoHu laoHu){
		this.name = name;
		this.laohu = laoHu;
	}
	public void askForJappenPic(final String gifInfo){
		new Thread(new Runnable() {
			@Override
			public void run() {
				/**
				 * liu向hu要岛国小照片
				 */
				laohu.giveMeSomeGifPic(LaoLiu.this, gifInfo);
			}
		}).start();
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.watchTv();
	}
	private void watchTv(){
		System.out.println("我看大片去啦...一会儿把图刊给我发过来。。。");
	}
	@Override
	public String giveYouSomeGifPic(String callbackContent) {
		System.out.println(callbackContent);
		return callbackContent;
	}
	
}
