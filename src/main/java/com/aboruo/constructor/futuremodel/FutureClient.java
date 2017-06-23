package com.aboruo.constructor.futuremodel;

public class FutureClient {
	public Data request(final String queryStr){
		/** 1. 先给客户端一个虚拟的数据，告诉客户端正在查询 */
		System.out.println(queryStr);
		final FutureData futureData = new FutureData();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("FutureClient正在积极查询真实数据...");
				RealData realData = RealData.getRealData(queryStr);
				futureData.setRealData(realData);
			}
		}).start();
		return futureData;
	}
}
