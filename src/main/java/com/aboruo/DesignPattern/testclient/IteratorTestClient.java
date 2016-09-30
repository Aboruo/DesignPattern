package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.iterator.dao.ArrayTestUtil;
import com.aboruo.DesignPattern.iterator.dao.Collection;
import com.aboruo.DesignPattern.iterator.dao.Iterator;

public class IteratorTestClient {

	public static void main(String[] args) {
		String[] testStrArray = {"Hello","Aboruo","!","ni","hao"};
		Collection<String> collection = new ArrayTestUtil<String>(testStrArray);
		collection.add("!");
		
		Iterator<String> iterator = collection.iterator();
		/** 1 遍历整个容器 */
		System.out.println("开始遍历容器中的元素");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("容器中元素遍历完成");
		
		/** 2 获取容器中当前位置的前一个元素 */
		if(iterator.hasNext()) System.out.println("容器中当前元素是：" + iterator.next());
		String eleStr = iterator.previous();
		System.out.println("容器中当前元素的前一个元素是：" + eleStr);
		
		/** 3 删除当前容器中的元素 */
		iterator.remove();
		if(iterator.hasNext()) System.out.println("删除元素后当前元素是：" + iterator.next());
	}

}
