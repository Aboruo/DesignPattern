package com.aboruo.constructor.queuelearn;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
	}
	
}
