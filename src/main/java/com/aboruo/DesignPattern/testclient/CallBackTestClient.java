package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.CallBack.dao.impl.LaoHu;
import com.aboruo.DesignPattern.CallBack.dao.impl.LaoLiu;

/**
 * 类名称：CallBackTestClient
 * 类描述：java回调模式
 * @author aboruo
 * @date 2016年12月14日 下午3:15:52
 */
public class CallBackTestClient {

	public static void main(String[] args) {
		LaoHu laoHu = new LaoHu("Hu da huang");
		LaoLiu liuHongJie = new LaoLiu("Lao liu", laoHu);
		liuHongJie.askForJappenPic("给我点岛国小图刊耍耍。。。");
	}

}
