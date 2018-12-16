package com.aboruo.disruptor.study.lession02;

import com.lmax.disruptor.EventHandler;

public class OrderEventHandler implements EventHandler<OrderEvent> {
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
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println(this.handlerName + "处理了消息：" +event + "|" + event.getOrderId() + "|" + event.getOrderDate() + "|" + event.getAmount());
	}

}
