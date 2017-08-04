package com.aboruo.disruptor.study.lession02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.lmax.disruptor.EventFactory;

public class OrderEventFactory implements EventFactory<OrderEvent> {
	private static Lock lock = new ReentrantLock();
	@Override
	public OrderEvent newInstance() {
		OrderEvent orderEvent = null;
		try {
			lock.lock();
			orderEvent = new OrderEvent();
			System.out.println("信息工厂生成消息：" + orderEvent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return orderEvent;
	}

}
