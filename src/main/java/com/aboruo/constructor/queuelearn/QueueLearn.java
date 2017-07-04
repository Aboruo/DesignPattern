package com.aboruo.constructor.queuelearn;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueLearn {

	public static void main(String[] args){
		/** 1 ArrayBlockingQueue测试 */
		BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.offer("b");
		arrayBlockingQueue.add("c");
		arrayBlockingQueue.offer("d");
		arrayBlockingQueue.add("e");
		try {
			arrayBlockingQueue.offer("f", 3, TimeUnit.SECONDS);
			for (Iterator<String> iterator = arrayBlockingQueue.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				System.out.println(string);
				arrayBlockingQueue.peek();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/** 2 LinkedBlockingQueue 测试 */
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(5);
		blockingQueue.add("a");
		blockingQueue.add("b");
		blockingQueue.add("c");
		blockingQueue.add("d");
		blockingQueue.add("e");
		/*try {
//			blockingQueue.offer("f", 3, TimeUnit.SECONDS);
//			blockingQueue.add("g");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("linkedBlockingQueue.size ===" + blockingQueue.size());
		for (Iterator<String> iterator = blockingQueue.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		/** 3. priorityBlockingQueue */
		PriorityBlockingQueue<QueueElement> blockingQueue2 = new PriorityBlockingQueue<QueueElement>();
		QueueElement queueElement1 = new QueueElement(1, "队列元素1");
		QueueElement queueElement2 = new QueueElement(6, "队列元素2");
		QueueElement queueElement3 = new QueueElement(3, "队列元素3");
		blockingQueue2.add(queueElement1);
		blockingQueue2.add(queueElement2);
		blockingQueue2.add(queueElement3);
		
		while(blockingQueue2.size() > 0){
			try {
				QueueElement queueElement = blockingQueue2.take();
				System.out.println(queueElement);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
