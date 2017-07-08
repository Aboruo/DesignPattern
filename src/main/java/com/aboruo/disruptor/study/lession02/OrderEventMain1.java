package com.aboruo.disruptor.study.lession02;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class OrderEventMain1 {

	public static void main(String[] args) {
		int BUFFER_SIZE = 1024;
		int THREAD_NUMBERS = 4;
		/* 
         * createSingleProducer创建一个单生产者的RingBuffer， 
         * 第一个参数叫EventFactory，从名字上理解就是"事件工厂"，其实它的职责就是产生数据填充RingBuffer的区块。 
         * 第二个参数是RingBuffer的大小，它必须是2的指数倍 目的是为了将求模运算转为&运算提高效率 
         * 第三个参数是RingBuffer的生产都在没有可用区块的时候(可能是消费者（或者说是事件处理器） 太慢了)的等待策略 
         */ 
		final RingBuffer<OrderEvent> ringBuffer = RingBuffer.createSingleProducer(new OrderEventFactory(), BUFFER_SIZE, new YieldingWaitStrategy());
		//创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBERS);
		//创建SequenceBarrier
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		//创建消息处理器
		BatchEventProcessor<OrderEvent> transProcessor = new BatchEventProcessor<>(ringBuffer, sequenceBarrier, new OrderEventHandler("处理器1"));
		//把消費者的位置引用信息注入給生產者，如果只有一個消費者時這一步可以省略
		ringBuffer.addGatingSequences(transProcessor.getSequence());
		
		//把消息處理器提交到線程池
		executorService.submit(transProcessor);
		
		/** 如果存在多个消费者 那重复执行上面3行代码 把TradeHandler换成其它消费者类 */
		Future<?> future = executorService.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				long seq = 0;
				OrderEvent orderEvent = null;
				for(int i = 0;i < 10;i++){
					seq = ringBuffer.next();
					orderEvent = ringBuffer.get(seq);
					orderEvent.setOrderId(UUID.randomUUID().toString());
					orderEvent.setOrderDate(getCurrentStringDateHHMMSS());
					orderEvent.setAmount(BigDecimal.valueOf(Math.random() * 9999));
					ringBuffer.publish(seq);
					Thread.sleep(1000);
				}
				return null;
			}
		});
		try {
			System.out.println("等待處理結果");
			future.get();
			System.out.println("數據處理完成......");
			Thread.sleep(2000);
			transProcessor.halt();
			executorService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @Title:getCurrentStringDateHHMMSS
	 * @Description: 獲取當前日期String
	 * @author:aboruo
	 * @return String
	 * @date 2017年7月6日 下午3:45:00
	 */
	public static String getCurrentStringDateHHMMSS()  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date(System.currentTimeMillis());

		return sdf.format(currentDate);

	}
}
