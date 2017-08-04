package com.aboruo.constructor.disruptor.learn01;

import com.lmax.disruptor.EventFactory;

/**
 * 类描述: 
 * 类名称: RequestEventFactory
 * @author aboruo
 * @date 2017年7月2日 下午3:56:27
 * @since 1.0.0
 */
public class RequestEventFactory implements EventFactory<RequestEvent> {
	/**
	 * @name: @return
	 * @description: 
	 * @author: aboruo
	 * @return: EventFactory<RequestEvent> 
	 * @sine: 2017年7月2日 下午3:56:41
	 */
	@Override
	public RequestEvent newInstance() {
		return new RequestEvent();
	}

}
