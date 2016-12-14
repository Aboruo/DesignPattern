package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.CallBack.dao.impl.LaoHu;
import com.aboruo.DesignPattern.CallBack.dao.impl.LiuHongJie;

/**
 * 类名称：CallBackTestClient
 * 类描述：java回调模式-宏杰向老胡要毛片
 * @author aboruo
 * @date 2016年12月14日 下午3:15:52
 */
public class CallBackTestClient {

	public static void main(String[] args) {
		LaoHu laoHu = new LaoHu("Hu da huang");
		LiuHongJie liuHongJie = new LiuHongJie("liu hongjie", laoHu);
		liuHongJie.askForJappenPic("给我点岛国小图刊耍耍。。。");
	}

}
