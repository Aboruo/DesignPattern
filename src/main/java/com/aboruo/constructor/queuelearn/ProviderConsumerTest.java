package com.aboruo.constructor.queuelearn;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类名称：ProviderConsumerTest
 * 类描述：生产者消费者测试
 * @author aboruo
 * @date 2017年6月27日 下午4:41:58
 */
public class ProviderConsumerTest {

	public static void main(String[] args) {
		/** 1. 构建消息队列 */
		ConcurrentLinkedQueue<Message> messageQueue = new ConcurrentLinkedQueue<>();
		CountDownLatch countDownLatch = new CountDownLatch(100);
		
		/** 2. 分别创建5个生产者和消费者 */
		Provider[] providers = new Provider[5];
		Consumer[] consumers = new Consumer[5];
		for(int i = 0,j=1 ; i < providers.length;i++,j++){
			providers[i] = new Provider("provider-" + j,"生产线程-" + j);
			providers[i].setMessageQueue(messageQueue);
			consumers[i] = new Consumer("consumer-" + j,"消费线程-" + j,countDownLatch);
			consumers[i].setMessageQueue(messageQueue);
		}
		
		/** 3. 启动生产者和消费者线程 */
		/*for(int k = 0; k < providers.length;k++){
			providers[k].start();
		}
		for(int k = 0; k < providers.length; k++){
			consumers[k].start();
		}*/
		
		/** 使用线程池的方式启动线程 */
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int k = 0; k < providers.length;k++){
			executorService.execute(providers[k]);
		}
		for(int k = 0; k < providers.length; k++){
			executorService.execute(consumers[k]);
		}
		
		/** 4. 打印main主线程执行完毕信息 */
		try {
			countDownLatch.await();
			System.out.println("主线程执行完成");
			executorService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
