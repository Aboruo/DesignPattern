package com.aboruo.constructor.futuremodel;

public class FutureTest {

	public static void main(String[] args) {
		FutureClient futureClient = new FutureClient();
		Data futureData = futureClient.request("查询第一步的数据");
//		System.out.println(futureData.getRequest());
		System.out.println("业务逻辑正在进行第二步的查询");
	}

}
