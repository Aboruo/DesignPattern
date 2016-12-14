package com.aboruo.DesignPattern.testclient;

import java.util.HashMap;
import java.util.Map;

import com.aboruo.DesignPattern.chainofresponsibility.abs.BusinessDealChain;
import com.aboruo.DesignPattern.chainofresponsibility.abs.impl.BusinessDealChainImpl;
import com.aboruo.DesignPattern.chainofresponsibility.dao.BusinessDealDao;
import com.aboruo.DesignPattern.chainofresponsibility.dao.impl.CTOManagerDeal;
import com.aboruo.DesignPattern.chainofresponsibility.dao.impl.DepartMentManagerDeal;
import com.aboruo.DesignPattern.chainofresponsibility.dao.impl.ProjectManagerDeal;

public class ChainOfResponsibilityTest {

	public static void main(String[] args) {
		/** 1 创建业务请求参数，申请报销信息 */
		Map<String,Object> param1 = new HashMap<String,Object>();
		param1.put("userName", "张三");
		param1.put("applyFunds", 1000);
		
		/** 2 创建各个处理角色 */
		BusinessDealDao businessDealDao1 = new ProjectManagerDeal();
		BusinessDealDao businessDealDao2 = new DepartMentManagerDeal();
		BusinessDealDao businessDealDao3 = new CTOManagerDeal();
		
		/** 3 创建业务处理链对象 */
		BusinessDealChain businessDealChain = new BusinessDealChainImpl();
		businessDealChain.addDeal(businessDealDao1);
		businessDealChain.addDeal(businessDealDao2);
		businessDealChain.addDeal(businessDealDao3);
		
		businessDealChain.doDealChain(param1);
//		System.out.println(retValue.toJSONString());
	}

}
