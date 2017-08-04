package com.aboruo.disruptor.study.lession04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.aboruo.disruptor.study.lession02.OrderEventFactory;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 类描述: 
 * 类名称: OrderEventMultiLogic2
 * @author aboruo
 * @date 2017年7月8日 下午5:10:43
 * @since 1.0.0
 */
public class OrderEventMultiLogic2 {

	/**
	 * @Title: main
	 * @description: TODO
	 * @author: aboruo
	 * @return void
	 * @sine: 2017年7月8日 下午5:10:43
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/** ringbuffer的大小 */
		int Buffer_size = 8;
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		/** 2 初始化disruptor */
		Disruptor<OrderEvent> disruptor = new Disruptor<>(new OrderEventFactory(), Buffer_size, threadFactory, ProducerType.SINGLE, new YieldingWaitStrategy());
		disruptor.setDefaultExceptionHandler(new IgnoreExceptionHandler());
		
		/** 3 定义消费者 */
		OrderEventProcessor handler1 = new OrderEventProcessor("handler1");
		OrderEventProcessor2 handler2 = new OrderEventProcessor2("handler2");
		OrderEventProcessor3 handler3 = new OrderEventProcessor3("handler3");
		OrderEventProcessor4 handler4 = new OrderEventProcessor4("handler4");
		OrderEventProcessor5 handler5 = new OrderEventProcessor5("handler5");
		
		/** 4 disruptor 定义消费者执行顺序 */
		disruptor.handleEventsWith(handler1,handler3);
		disruptor.after(handler1).then(handler4);
		disruptor.after(handler3).then(handler5);
		disruptor.after(handler4,handler5).then(handler2);
		
		disruptor.start();
		
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
