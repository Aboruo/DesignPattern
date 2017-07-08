package com.aboruo.constructor.disruptor.learn01;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 类描述: 
 * 类名称: RequestEventMain
 * @author aboruo
 * @date 2017年7月2日 下午4:02:28
 * @since 1.0.0
 */
public class RequestEventMain {
	/**
	 * @Title: main
	 * @description: TODO
	 * @author: aboruo
	 * @return void
	 * @sine: 2017年7月2日 下午4:02:28
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/** 1.requestEvent工厂类 */
		EventFactory<RequestEvent> eventFactory = new RequestEventFactory();
		/** 2. ringBuffer缓冲区大小，必须是2的N次方 */
		int ringBufferSize = 1024 * 1024;
		/** 3. 线程池 */
		ThreadFactory threadFactory = Executors.privilegedThreadFactory();
		/** 4. RequestEvent生产者类型，是多个还是单个，即：multi or single */
		ProducerType producerType = ProducerType.SINGLE;
		/** 5. 消息处理等待策略 */
		WaitStrategy waitStrategy = new YieldingWaitStrategy();
		/**
		//BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
		WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
		//SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
		WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
		//YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
		WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
		*/ 
		Disruptor<RequestEvent> disruptor = new Disruptor<RequestEvent>(eventFactory, ringBufferSize, threadFactory, producerType, waitStrategy);
		//连接requestEvent消息观察者或消息消费者
		disruptor.handleEventsWith(new RequestEventHandler());
		//启动disruptor
		disruptor.start();
		
		//生产消息并发布消息
		RingBuffer<RequestEvent> ringBuffer = disruptor.getRingBuffer();
		ReqeustEventProducer reqeustEventProducer = new ReqeustEventProducer(ringBuffer);
		String msgInfo = "";
		for(int i = 0 ; i < 100; i++){
			msgInfo = "消息-" + i;
			reqeustEventProducer.onData(msgInfo);
		}
		disruptor.shutdown();
	}

}
