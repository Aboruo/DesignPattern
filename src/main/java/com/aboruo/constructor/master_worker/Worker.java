package com.aboruo.constructor.master_worker;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker extends Thread {
	private int workerId;
	private String workerName;
	/** 任务队列 */
	private ConcurrentLinkedQueue<Task> concurrentLinkedQueue;
	/** 每一个worker的处理集合 */
	private Map<String,Integer> resutlMap = new ConcurrentHashMap<String,Integer>();
	private Random random = new Random();
	public Worker(int workerId,String workerName){
		this.workerId = workerId;
		this.workerName = workerName;
	}
	public ConcurrentLinkedQueue<Task> getConcurrentLinkedQueue() {
		return concurrentLinkedQueue;
	}
	public Map<String, Integer> getResutlMap() {
		return resutlMap;
	}
	public int getWorkerId() {
		return workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	@Override
	public void run() {
		while(!concurrentLinkedQueue.isEmpty()){
			Task task = concurrentLinkedQueue.poll();
			System.out.println(this.getName() + " 正在处理任务：" + task);
			try {
				Thread.sleep(500);
				resutlMap.put(task.getId(), random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setConcurrentLinkedQueue(ConcurrentLinkedQueue<Task> concurrentLinkedQueue) {
		this.concurrentLinkedQueue = concurrentLinkedQueue;
	}
	public void setResutlMap(Map<String, Integer> resutlMap) {
		this.resutlMap = resutlMap;
	}
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

}
