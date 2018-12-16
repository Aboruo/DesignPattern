package com.aboruo.constructor.disruptor.learn01;

import com.lmax.disruptor.RingBuffer;

/**
 * 类描述: 
 * 类名称: ReqeustEventProducer
 * @author aboruo
 * @date 2017年7月2日 下午4:32:13
 * @since 1.0.0
 */
public class ReqeustEventProducer {
	private final RingBuffer<RequestEvent> ringBuffer;
	
	public ReqeustEventProducer(RingBuffer<RequestEvent> ringBuffer){
		this.ringBuffer = ringBuffer;
	}
	/**
	 * @Title: onData
	 * @description: onData用来发布事件，每调用一次就发布一次事件
	 * 它的参数会用过事件传递给消费者
	 * @author: aboruo
	 * @return void
	 * @sine: 2017年7月2日 下午4:34:33
	 */
	public void onData(String msginfo){
		//1.可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
		long sequence = ringBuffer.next();
		try {
			//2. 通过上面一个索引取出一个空的RequestEvent对象引用
			RequestEvent requestEvent = ringBuffer.get(sequence);
			//3. 填入：要通过requestEvent事件处理的消息内容
			requestEvent.setRequestInfo(msginfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//4.发布事件
			//注意，最后的 ringBuffer.publish 方法必须包含在 finally 中以确保必须得到调用；如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
			ringBuffer.publish(sequence);
		}
	}
}
