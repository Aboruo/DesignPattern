package com.aboruo.disruptor.study.lession03;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.aboruo.disruptor.study.lession02.OrderEventFactory;
import com.aboruo.disruptor.study.lession02.OrderEventMain1;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.YieldingWaitStrategy;

public class OrderEventMain2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		/** 1. bufferSize */
		int bufferSize = 1024;
		/** 2. 创建线程池 */
		int thread_nums = 4;
		ExecutorService executorService = Executors.newFixedThreadPool(thread_nums);
		
		/** 3. 定义ringbuffer */
		RingBuffer<OrderEvent> ringBuffer = RingBuffer.createSingleProducer(new OrderEventFactory(), bufferSize, new YieldingWaitStrategy());
		
		/** 4. 定义SequenceBarrier及消费者 */
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		WorkHandler<OrderEvent> workHandler = new OrderEventHandler("处理器1");
		WorkerPool<OrderEvent> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), workHandler);
		workerPool.start(executorService);
		
		/** 5. 生产10个OrderEvent */
		OrderEvent orderEvent = null;
		for(int i = 0; i < 10;i++){
			long seq = ringBuffer.next();
			orderEvent = ringBuffer.get(seq);
			orderEvent.setAmount(BigDecimal.valueOf(Math.random() * 10000));
			orderEvent.setOrderId(UUID.randomUUID().toString());
			orderEvent.setOrderDate(OrderEventMain1.getCurrentStringDateHHMMSS());
			ringBuffer.publish(seq);
		}
		Thread.sleep(2000);
		executorService.shutdown();
		workerPool.halt();
	}

}
