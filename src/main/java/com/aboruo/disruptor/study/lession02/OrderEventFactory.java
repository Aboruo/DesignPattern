package com.aboruo.disruptor.study.lession02;

import com.lmax.disruptor.EventFactory;

public class OrderEventFactory implements EventFactory<OrderEvent> {

	@Override
	public OrderEvent newInstance() {
		return new OrderEvent();
	}

}
