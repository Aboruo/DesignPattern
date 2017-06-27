package com.aboruo.constructor.queuelearn;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名称：Provider
 * 类描述：生产-消费队列模式中的—生产者
 * @author aboruo
 * @date 2017年6月27日 上午10:08:14
 */
public class Provider extends Thread {
	private ConcurrentLinkedQueue<Message> messageQueue;
	private String pid;
	private String pname;
	private static AtomicInteger count = new AtomicInteger(0);
	public Provider(String string, String string2) {
		this.pid = string;
		this.pname = string2;
	}
	/**
	 * @return the messageQueue
	 */
	public ConcurrentLinkedQueue<Message> getMessageQueue() {
		return messageQueue;
	}
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param messageQueue the messageQueue to set
	 */
	public void setMessageQueue(ConcurrentLinkedQueue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void run(){
		while(count.intValue() < 100){
			try {
				/** 向队列中生产消息 */
				int msgId = count.incrementAndGet();
				Message message = new Message("msg-" + msgId,"消息-" + msgId);
				this.messageQueue.add(message);
				System.out.println(this.pname + "生产了：" + message);
				Thread.sleep(200); //线程沉睡200ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
