package com.aboruo.constructor.queuelearn;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * 类名称：Consumer
 * 类描述：生产-消费队列模式中的—消费者
 * @author aboruo
 * @date 2017年6月27日 上午10:07:42
 */
public class Consumer extends Thread {
	private ConcurrentLinkedQueue<Message> messageQueue;
	private CountDownLatch countDownLatch;
	private String cid;
	private String cname;
	public Consumer(String string, String string2,CountDownLatch countDownLatch) {
		this.cid = string;
		this.cname = string2;
		this.countDownLatch = countDownLatch;
	}
	/**
	 * @return the messageQueue
	 */
	public ConcurrentLinkedQueue<Message> getMessageQueue() {
		return messageQueue;
	}
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @param messageQueue the messageQueue to set
	 */
	public void setMessageQueue(ConcurrentLinkedQueue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	public void run(){
		while(!this.messageQueue.isEmpty()){
			try {
				/** 向队列中生产消息 */
				Message message = this.messageQueue.poll();
				System.out.println(this.cname +"获取并消费了：" + message);
				countDownLatch.countDown();
				Thread.sleep(300); //线程沉睡200ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
