package com.aboruo.disruptor.study.lession03;

import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class OrderEventHandler implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {
	private String handlerName;

	public OrderEventHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	/**
	 * @return the handlerName
	 */
	public String getHandlerName() {
		return handlerName;
	}

	/**
	 * @param handlerName the handlerName to set
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void onEvent(OrderEvent event) throws Exception {
		System.out.println(this.handlerName + "处理了：" + event.getOrderId() + "|" + event.getOrderDate());
	}

	@Override
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
		this.onEvent(event);
	}

}
