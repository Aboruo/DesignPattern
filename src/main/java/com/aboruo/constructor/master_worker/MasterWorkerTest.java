package com.aboruo.constructor.master_worker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MasterWorkerTest {

	public static void main(String[] args) {
		/** 1 创建任务队列 */
		ConcurrentLinkedQueue<Task> concurrentLinkedQueue = createTaskQueue(100);
		
		/** 2 创建worker集合 */
		Map<String, Worker> workerMap = createWorkerMap(5);
		
		/** 3 初始化Master */
		Master master = new Master(concurrentLinkedQueue,workerMap);
		master.execute();
		master.start();
		int result = master.getResult();
		System.out.println("处理结果：" + result);
	}

	private static Map<String, Worker> createWorkerMap(int workerNums) {
		Map<String, Worker> workerMap = new ConcurrentHashMap<String, Worker>();
		for(int i = 0 ;i < workerNums;i++){
			Worker worker = new Worker(i,"线程worker-" + i);
			workerMap.put("worker-" + i, worker);
		}
		return workerMap;
	}

	/**
	 * 构造任务队列
	 * @param taskNums
	 * @return
	 */
	private static ConcurrentLinkedQueue<Task> createTaskQueue(int taskNums) {
		ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();
		Task task = null;
		for(int i = 0;i < taskNums;i++){
			task = new Task("Task-" + i,"任务-" + i);
			taskQueue.add(task);
		}
		return taskQueue;
	}

}
