package com.aboruo.disruptor.study.lession04;

import java.util.concurrent.CountDownLatch;
import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * 类名称：OrderEventPublisher
 * 类描述：orderEvent生产者
 * @author aboruo
 * @date 2017年7月6日 下午6:29:56
 */
public class OrderEventPublisher implements Runnable {
	private final Disruptor<OrderEvent> disruptor;
	private CountDownLatch countDownLatch;
//	private static int LOOP = 10;//模拟百万次交易的发生 
	@Override
	public void run() {
		OrderEventTranslator orderEventTranslator = new OrderEventTranslator();
//		for(int i = 0; i < LOOP;i++){
			this.disruptor.publishEvent(orderEventTranslator);
//		}
		countDownLatch.countDown();
	}
	public OrderEventPublisher(Disruptor<OrderEvent> disruptor, CountDownLatch countDownLatch) {
		super();
		this.disruptor = disruptor;
		this.countDownLatch = countDownLatch;
	}
}
