package com.aboruo.disruptor.study.lession04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.aboruo.disruptor.study.lession02.OrderEventFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class OrderEventMultiLogic {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/** 1. ringbuffer缓存池大小 */
		int bufferSize = 1024 * 1024;
		
		/** 2. 线程工厂 */
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Disruptor<OrderEvent> disruptor = new Disruptor<>(new OrderEventFactory(), bufferSize, threadFactory, ProducerType.SINGLE, new YieldingWaitStrategy());
		OrderEventProcessor handler1 = new OrderEventProcessor("handler1");
		OrderEventProcessor handler2 = new OrderEventProcessor("handler2");
		OrderEventProcessor handler3 = new OrderEventProcessor("handler3");
		disruptor.handleEventsWith(handler1,handler2);
		disruptor.after(handler1,handler2).then(handler3);
		disruptor.start();//启动  
        CountDownLatch latch=new CountDownLatch(1);  
        //生产者准备  
        executorService.submit(new OrderEventPublisher(disruptor,latch));
        try {
			latch.await();
			System.out.println("生成订单操作完成");
			Thread.sleep(3000);
			disruptor.halt();
			executorService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
