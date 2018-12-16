package com.aboruo.disruptor.study.lession01;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 类名称：TradeEventTest
 * 类描述：交易事件測試
 * @author aboruo
 * @date 2017年7月6日 下午4:02:48
 */
public class TradeEventTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
		int ringBufferSize = 1024 * 1024;
		RingBuffer<TradeEvent> ringBuffer = null;
		EventFactory<TradeEvent> eventFactory = new TradeEventFactory();
		ThreadFactory threadFactory  = Executors.defaultThreadFactory();
		/**
		//BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
		WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
		//SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
		WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
		//YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
		WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
		*/
		/** 1. 创建disruptor,并初始化生产者 */
		Disruptor<TradeEvent> disruptor = new Disruptor<>(eventFactory, ringBufferSize, threadFactory, ProducerType.SINGLE, new YieldingWaitStrategy());
		disruptor.handleEventsWith(new TradeEventConsumer<TradeEvent>("消费者1"),new TradeEventConsumer<TradeEvent>("消费者2"));
		ringBuffer = disruptor.start();
		TradeEventProducer tradeEventProducer = new TradeEventProducer(ringBuffer);
		
		/** 2. 生产者生产10个event */
		Map<String,String> dataMap = new ConcurrentHashMap<String,String>();
		for(int i = 0; i < 10; i++){
			dataMap.put("tradeId",UUID.randomUUID().toString());
			dataMap.put("trandeName", "订单" + i);
			dataMap.put("tradeAmount",Math.random() * 9999 + "");
			tradeEventProducer.onData(dataMap);
		}
		disruptor.shutdown();
		System.out.println("数据生产完成");
	}

}
