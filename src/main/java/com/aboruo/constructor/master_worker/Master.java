package com.aboruo.constructor.master_worker;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author aboruo
 *
 */
public class Master extends Thread {
	/** 任务队列 */
	private ConcurrentLinkedQueue<Task> concurrentLinkedQueue;
	/** worker集合 */
	private Map<String,Worker> workerMap;
	/** 每一个worker的处理集合 */
	private Map<String,Integer> resutlMap = new ConcurrentHashMap<String,Integer>();
	private int result;
	public synchronized int getResult() {
		if(!isJobComplete()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Master(){}
	/**
	 * @方法说明 : master构造方法
	 * @param concurrentLinkedQueue
	 * @param workNums
	 */
	public Master(ConcurrentLinkedQueue<Task> concurrentLinkedQueue,Map<String,Worker> workerMap){
		this.concurrentLinkedQueue = concurrentLinkedQueue;
		for(Iterator<String> iterator = workerMap.keySet().iterator();iterator.hasNext();){
			String keyStr = iterator.next();
			Worker worker = workerMap.get(keyStr);
			worker.setConcurrentLinkedQueue(concurrentLinkedQueue);
			worker.setResutlMap(resutlMap);
		}
		this.workerMap = workerMap;
	}

	public ConcurrentLinkedQueue<Task> getConcurrentLinkedQueue() {
		return concurrentLinkedQueue;
	}

	public void setConcurrentLinkedQueue(ConcurrentLinkedQueue<Task> concurrentLinkedQueue) {
		this.concurrentLinkedQueue = concurrentLinkedQueue;
	}

	public Map<String, Worker> getWorkerMap() {
		return workerMap;
	}

	public void setWorkerMap(Map<String, Worker> workerMap) {
		this.workerMap = workerMap;
	}

	public Map<String, Integer> getResutlMap() {
		return resutlMap;
	}

	public void setResutlMap(Map<String, Integer> resutlMap) {
		this.resutlMap = resutlMap;
	}
	public void execute() {
		for (Iterator<String> iterator = workerMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			Worker worker = workerMap.get(key);
			worker.start();
		}
	}
	
	
	/**
	 * @Title: isJobComplete
	 * @description: 判断所有worker的任务是否都已经完成
	 * @author: aboruo
	 * @return boolean
	 * @sine: 2017年6月24日 下午1:11:54
	 */
	private boolean isJobComplete(){
		for (Iterator<String> iterator = workerMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			Worker worker = workerMap.get(key);
			if(worker.getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	public void run(){
		while(true){
			if (isJobComplete()) {
				this.calculateResults();
				break;
			}
		}
	}
	/**
	 * @Title: calculateResults
	 * @description: 计算结果值
	 * @author: aboruo
	 * @return void
	 * @sine: 2017年6月24日 下午5:20:09
	 */
	public synchronized void calculateResults(){
		if(!isJobComplete()){
			return; 
		}
		
		/** 计算结果值 */
		int result = 0;
		for(Iterator<String> iterator = resutlMap.keySet().iterator();iterator.hasNext();){
			String key = iterator.next();
			result += resutlMap.get(key).intValue();
		}
		this.result = result;
		notify();
	}
}
