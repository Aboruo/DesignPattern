package com.aboruo.constructor.disruptor.learn01;

import com.lmax.disruptor.EventHandler;

/**
 * 类描述: 
 * 类名称: RequestEventHandler
 * @author aboruo
 * @date 2017年7月2日 下午3:59:10
 * @since 1.0.0
 */
public class RequestEventHandler implements EventHandler<RequestEvent> {

	/**
	 * @name: @param arg0
	 * @name: @param arg1
	 * @name: @param arg2
	 * @name: @throws Exception
	 * @description: 
	 * @author: aboruo
	 * @return: RequestEventHandler 
	 * @sine: 2017年7月2日 下午3:59:10
	 */
	@Override
	public void onEvent(RequestEvent requestEvent, long arg1, boolean arg2) throws Exception {
		System.out.println("处理：" + requestEvent.getRequestInfo());
	}

}
