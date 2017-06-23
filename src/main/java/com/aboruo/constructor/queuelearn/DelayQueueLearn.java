package com.aboruo.constructor.queuelearn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueLearn implements Runnable {
	private BlockingQueue<NetPlayer> blockingQueue = new DelayQueue<NetPlayer>();
	private boolean yingye = true;
	public void startPlay(String id,String name,int money){
		NetPlayer netPlayer = new NetPlayer(id,name,money * 1000 + System.currentTimeMillis());
		blockingQueue.offer(netPlayer); //上网者添加到队列中
		System.out.println("身份证号：" + id + ",姓名为：" + name + "开始上网...");
	}
	public void stopPlay(NetPlayer netPlayer){
		System.out.println(netPlayer.getName() + "上网时间结束");
	}
	@Override
	public void run() {
		while(yingye){
			NetPlayer netPlayer;
			try {
				netPlayer = blockingQueue.take();
				stopPlay(netPlayer);
				yingye = blockingQueue.size() > 0 ? true:false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DelayQueueLearn delayQueueLearn = new DelayQueueLearn();
		new Thread(delayQueueLearn).start();
		delayQueueLearn.startPlay("1", "张三", 4);
		delayQueueLearn.startPlay("2", "李四", 8);
		delayQueueLearn.startPlay("3", "王五", 8);
	}

}
