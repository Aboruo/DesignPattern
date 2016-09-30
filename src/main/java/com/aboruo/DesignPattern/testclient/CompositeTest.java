package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Composite.entity.Family;
import com.aboruo.DesignPattern.Composite.entity.PersonNode;

public class CompositeTest {

	public static void main(String[] args) {
		PersonNode houseHolder = new PersonNode("AAA","男",30);
		Family family = new Family(houseHolder);
		
		/** 创建父母变量 */
		PersonNode father = new PersonNode("AAAfa","男",51);
		PersonNode mother = new PersonNode("AAAmo","女",51);
		houseHolder.addParent(father);
		houseHolder.addParent(mother);
		
		/** 创建子女变量 */
		PersonNode son01 = new PersonNode("AAAson01","男",10);
		PersonNode girl01 = new PersonNode("AAAgirl02","女",10);
		houseHolder.addChildren(son01);
		houseHolder.addChildren(girl01);
		
		System.out.println(family);
	}

}
